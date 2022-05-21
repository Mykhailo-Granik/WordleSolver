package wordle.colorizing;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
public class GuessColorizer {

    private final String answer;
    private Set<Integer> usedAnswerPositions;

    public List<LetterColor> colorize(String guess) {
        usedAnswerPositions = new HashSet<>();
        List<LetterColor> result = markExactMatches(guess, initializeAllGrey());
        return markNotExactMaches(guess, result);
    }

    private List<LetterColor> initializeAllGrey() {
        List<LetterColor> result = new ArrayList<>();
        for (int i = 0; i < answer.length(); ++i) {
            result.add(LetterColor.GREY);
        }
        return result;
    }

    private List<LetterColor> markExactMatches(String guess, List<LetterColor> allGrey) {
        List<LetterColor> result = new ArrayList<>(allGrey);
        for (int i = 0; i < answer.length(); ++i) {
            if (answer.charAt(i) == guess.charAt(i)) {
                result.set(i, LetterColor.GREEN);
                usedAnswerPositions.add(i);
            }
        }
        return result;
    }

    private List<LetterColor> markNotExactMaches(String guess, List<LetterColor> result) {
        for (int i = 0; i < answer.length(); ++i) {
            if (result.get(i) == LetterColor.GREEN) {
                continue;
            }
            for (int j = 0; j < answer.length(); ++j) {
                if (!usedAnswerPositions.contains(j) && guess.charAt(i) == answer.charAt(j)) {
                    usedAnswerPositions.add(j);
                    result.set(i, LetterColor.YELLOW);
                    break;
                }
            }
        }
        return result;
    }

}
