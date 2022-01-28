package wordle.algorithms.minimax;

import lombok.RequiredArgsConstructor;
import wordle.LetterColor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class MaxBucketSize {

    private final Map<List<LetterColor>, List<String>> buckets;

    public int maxSize() {
        return buckets.values().stream()
                .map(List::size)
                .max(Integer::compare)
                .orElse(0);
    }

}
