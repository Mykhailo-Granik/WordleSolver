package wordle.algorithms.minimax;

import lombok.RequiredArgsConstructor;
import wordle.*;
import wordle.algorithms.GuessCalculator;
import wordle.dictionary.AnswersProvider;
import wordle.dictionary.GuessesProvider;

import java.util.List;
import java.util.Map;

import static wordle.LetterColor.GREEN;

@RequiredArgsConstructor
public class MiniMaxAlgorithm implements GuessCalculator {

    private final GuessesProvider guessesProvider;
    private final AnswersProvider answersProvider;

    @Override
    public MiniMaxResult calculate() {
        if (answersProvider.provide().size() == 1) {
            return new MiniMaxResult(
                    answersProvider.provide().get(0),
                    1,
                    Map.of(List.of(GREEN, GREEN, GREEN, GREEN, GREEN), answersProvider.provide())
            );
        }
        MiniMaxResult result = new MiniMaxResult();
        guessesProvider.provide().forEach(guess -> {
            BucketsGenerator generator = new BucketsGenerator(
                    guess,
                    answersProvider
            );
            Map<List<LetterColor>, List<String>> buckets = generator.generate();
            MaxBucketSize maxBucketSize = new MaxBucketSize(buckets);
            MiniMaxResult currentResult = new MiniMaxResult(guess, maxBucketSize.maxSize(), buckets);
            result.updateIfNeeded(currentResult);
        });
        return result;
    }

}
