package wordle.algorithms.minimax;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wordle.LetterColor;
import wordle.algorithms.Guess;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class MiniMaxResult implements Guess {

    private String guess;
    private int size;
    private Map<List<LetterColor>, List<String>> buckets;

    public void updateIfNeeded(MiniMaxResult other) {
        if (guess == null || other.size < size) {
            guess = other.guess;
            size = other.size;
            buckets = other.buckets;
        }
    }

    @Override
    public String nextGuess() {
        return guess;
    }
}
