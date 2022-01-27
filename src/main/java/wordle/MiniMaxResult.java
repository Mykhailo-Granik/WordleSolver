package wordle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MiniMaxResult {

    private String guess;
    private int size;

    public void updateIfNeeded(MiniMaxResult other) {
        if (guess == null || other.size < size) {
            guess = other.guess;
            size = other.size;
        }
    }

}
