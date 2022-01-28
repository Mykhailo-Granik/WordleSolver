package wordle.algorithms.minimax;

import lombok.RequiredArgsConstructor;
import wordle.*;
import wordle.algorithms.GuessProvider;
import wordle.dictionary.AnswersProvider;
import wordle.dictionary.GuessesProvider;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class MiniMaxAlgorithm implements GuessProvider {

    private final GuessesProvider guessesProvider;
    private final AnswersProvider answersProvider;

    @Override
    public MiniMaxResult provide() {
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
