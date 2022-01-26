package wordle;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class BucketGenerator {

    private final AnswersProvider answersProvider;
    private final GuessColorizer guessColorizer;

    public Map<List<LetterColor>, List<String>> generate() {
        return null;
    }

}
