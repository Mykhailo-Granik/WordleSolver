package wordle.algorithms.minimax;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wordle.LetterColor;
import wordle.algorithms.Guess;

import java.util.List;
import java.util.Map;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class MiniMaxResult implements Guess {

    private String guess;
    private int size;
    private Map<List<LetterColor>, List<String>> buckets;

    public void updateIfNeeded(MiniMaxResult other) {
        if (shouldUpdate(other)) {
            guess = other.guess;
            size = other.size;
            buckets = other.buckets;
        }
    }

    private boolean shouldUpdate(MiniMaxResult other) {
        if (guess == null || other.size < size) {
            return true;
        }
        return (other.size == size) && (new Random().nextInt() % 2 == 0);
    }

    @Override
    public String nextGuess() {
        return guess;
    }

    @Override
    public List<String> answersMatchingResponse(List<LetterColor> response) {
        return buckets.get(response);
    }
}
