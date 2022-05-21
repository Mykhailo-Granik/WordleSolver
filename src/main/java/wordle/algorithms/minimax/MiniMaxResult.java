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

    public void updateIfNeeded(MiniMaxResult other) {
        if (shouldUpdate(other)) {
            guess = other.guess;
            size = other.size;
        }
    }

    private boolean shouldUpdate(MiniMaxResult other) {
        return guess == null || other.size < size;
    }

    @Override
    public String nextGuess() {
        return guess;
    }

}
