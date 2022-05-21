package wordle.algorithms.minimax;

import lombok.RequiredArgsConstructor;
import wordle.colorizing.LetterColor;
import wordle.algorithms.GuessCalculator;
import wordle.dictionary.AnswersProvider;
import wordle.dictionary.GuessesProvider;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class MiniMaxAlgorithm implements GuessCalculator {

    private final GuessesProvider guessesProvider;
    private final AnswersProvider answersProvider;

    @Override
    public MiniMaxResult calculate() {
        if (answerIssCertain()) {
            return answer();
        }
        MiniMaxResult result = new MiniMaxResult();
        guessesProvider.provide().forEach(guess -> result.updateIfNeeded(miniMaxForGuess(guess)));
        return result;
    }

    private boolean answerIssCertain() {
        return answersProvider.provide().size() == 1;
    }

    private MiniMaxResult answer() {
        return new MiniMaxResult(
                answersProvider.provide().get(0),
                1
        );
    }

    private MiniMaxResult miniMaxForGuess(String guess) {
        BucketsGenerator generator = new BucketsGenerator(
                guess,
                answersProvider
        );
        Map<List<LetterColor>, List<String>> buckets = generator.generate();
        MaxBucketSize maxBucketSize = new MaxBucketSize(buckets);
        return new MiniMaxResult(guess, maxBucketSize.maxSize());
    }

}
