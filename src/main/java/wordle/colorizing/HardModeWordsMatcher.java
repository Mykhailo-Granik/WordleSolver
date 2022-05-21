package wordle.colorizing;

import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
public class HardModeWordsMatcher {

    private final String previousGuess;
    private final String nextGuess;
    private final List<LetterColor> letterColors;
    private Set<Integer> usedPositions;

    public boolean match() {
        usedPositions = new HashSet<>();
        if (!matchGreenLetters()) {
            return false;
        }
        if (!matchYellowLetters()) {
            return false;
        }
        return matchGreyLetters();
    }

    private boolean matchGreenLetters() {
        for (int i = 0; i < letterColors.size(); ++i) {
            if (letterColors.get(i) == LetterColor.GREEN) {
                if (previousGuess.charAt(i) != nextGuess.charAt(i)) {
                    return false;
                }
                usedPositions.add(i);
            }
        }
        return true;
    }

    private boolean matchYellowLetters() {
        for (int i = 0; i < letterColors.size(); ++i) {
            if (letterColors.get(i) == LetterColor.YELLOW) {
                if (previousGuess.charAt(i) == nextGuess.charAt(i)) {
                    return false;
                }
                if (!foundCorrespondingYellow(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean foundCorrespondingYellow(int i) {
        int matchingIndex = matchingIndex(i);
        if (matchingIndex >= 0) {
            usedPositions.add(matchingIndex);
            return true;
        }
        return false;
    }

    private int matchingIndex(int i) {
        for (int j = 0; j < letterColors.size(); ++j) {
            if (usedPositions.contains(j)) {
                continue;
            }
            if (previousGuess.charAt(i) == nextGuess.charAt(j)) {
                return j;
            }
        }
        return -1;
    }

    private boolean matchGreyLetters() {
        for (int i = 0; i < letterColors.size(); ++i) {
            if (letterColors.get(i) == LetterColor.GREY) {
                if (foundCorrespondingGrey(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean foundCorrespondingGrey(int i) {
        return matchingIndex(i) >= 0;
    }

}
