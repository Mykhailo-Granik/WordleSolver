package wordle;

import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
public class WordsMatcher {

    private final String previousGuess;
    private final String nextGuess;
    private final List<LetterColor> letterColors;

    public boolean match() {
        Set<Integer> usedPositions = new HashSet<>();
        for (int i = 0; i < letterColors.size(); ++i) {
            if (letterColors.get(i) == LetterColor.GREEN) {
                if (previousGuess.charAt(i) != nextGuess.charAt(i)) {
                    return false;
                }
                usedPositions.add(i);
            }
        }

        for (int i = 0; i < letterColors.size(); ++i) {
            if (letterColors.get(i) == LetterColor.YELLOW) {
                if (previousGuess.charAt(i) == nextGuess.charAt(i)) {
                    return false;
                }
                boolean found = false;
                for (int j = 0; j < letterColors.size(); ++j) {
                    if (usedPositions.contains(j)) {
                        continue;
                    }
                    if (previousGuess.charAt(i) == nextGuess.charAt(j)) {
                        usedPositions.add(j);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return false;
                }
            }
        }

        for (int i = 0; i < letterColors.size(); ++i) {
            if (letterColors.get(i) == LetterColor.GREY) {
                for (int j = 0; j < letterColors.size(); ++j) {
                    if (usedPositions.contains(j)) {
                        continue;
                    }
                    if (previousGuess.charAt(i) == nextGuess.charAt(j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
