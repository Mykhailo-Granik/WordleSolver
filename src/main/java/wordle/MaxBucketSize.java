package wordle;

import lombok.RequiredArgsConstructor;

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
