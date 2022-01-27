package wordle;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class MiniMaxAlgorithm {

    private final GuessesProvider guessesProvider;
    private final AnswersProvider answersProvider;

    public MiniMaxResult calculate() {
        MiniMaxResult result = new MiniMaxResult();
        guessesProvider.provide().forEach(guess -> {
            BucketsGenerator generator = new BucketsGenerator(
                    answersProvider,
                    new GuessColorizer(guess)
            );
            Map<List<LetterColor>, List<String>> buckets = generator.generate();
            MaxBucketSize maxBucketSize = new MaxBucketSize(buckets);
            MiniMaxResult currentResult = new MiniMaxResult(guess, maxBucketSize.maxSize(), buckets);
            result.updateIfNeeded(currentResult);
        });
        return result;
    }

}
