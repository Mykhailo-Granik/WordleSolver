package wordle.algorithms.minimax;

import lombok.RequiredArgsConstructor;
import wordle.GuessColorizer;
import wordle.LetterColor;
import wordle.dictionary.AnswersProvider;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BucketsGenerator {

    private final String guess;
    private final AnswersProvider answersProvider;

    public Map<List<LetterColor>, List<String>> generate() {
        return answersProvider.provide().stream()
                .collect(Collectors.groupingBy(answer -> new GuessColorizer(answer).colorize(guess)));
    }

}
