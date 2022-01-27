package wordle;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BucketsGenerator {

    private final AnswersProvider answersProvider;
    private final GuessColorizer guessColorizer;

    public Map<List<LetterColor>, List<String>> generate() {
        return answersProvider.provide().stream()
                .collect(Collectors.groupingBy(guessColorizer::colorize));
    }

}
