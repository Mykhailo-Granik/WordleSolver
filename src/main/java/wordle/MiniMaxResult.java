package wordle;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class MiniMaxResult {

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

}
