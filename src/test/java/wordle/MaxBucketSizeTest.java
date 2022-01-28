package wordle;

import org.junit.jupiter.api.Test;
import wordle.algorithms.minimax.MaxBucketSize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static wordle.LetterColor.*;

public class MaxBucketSizeTest {

    private MaxBucketSize underTest;

    @Test
    public void whenThereIsOneBucketShouldReturnItsSize() {
        underTest = new MaxBucketSize(
                Map.of(List.of(GREY), List.of("a", "c", "b"))
        );
        assertEquals(3, underTest.maxSize());
    }

    @Test
    public void whenThereAreSeveralBucketsShouldReturnSizeOfTheBiggestOne() {
        underTest = new MaxBucketSize(
                Map.of(
                        List.of(GREY), List.of("a", "c", "b"),
                        List.of(GREEN), List.of("d", "e", "f", "g"),
                        List.of(YELLOW), List.of("h")
                )
        );
        assertEquals(4, underTest.maxSize());
    }

    @Test
    public void shouldReturnZeroWhenThereAreNoBuckets() {
        underTest = new MaxBucketSize(new HashMap<>());
        assertEquals(0, underTest.maxSize());
    }

}