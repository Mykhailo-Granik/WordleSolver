package wordle;

import org.junit.jupiter.api.Test;
import wordle.algorithms.minimax.MiniMaxResult;
import wordle.colorizing.LetterColor;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MiniMaxResultTest {

    @Test
    public void shouldUpdateIfResultNotSet() {
        MiniMaxResult underTest = new MiniMaxResult();
        Map<List<LetterColor>, List<String>> otherBuckets = Map.of(
                List.of(LetterColor.GREY), List.of("a", "b")
        );
        MiniMaxResult other = new MiniMaxResult("a", 2);
        underTest.updateIfNeeded(other);
        assertEquals(2, underTest.getSize());
        assertEquals("a", underTest.nextGuess());
    }

    @Test
    public void shouldUpdateIfOtherResultIsBetter() {
        Map<List<LetterColor>, List<String>> currentBuckets = Map.of(
                List.of(LetterColor.GREY), List.of("a", "b", "c")
        );
        MiniMaxResult underTest = new MiniMaxResult("b", 3);
        Map<List<LetterColor>, List<String>> otherBuckets = Map.of(
                List.of(LetterColor.GREY), List.of("a", "b")
        );
        MiniMaxResult other = new MiniMaxResult("a", 2);
        underTest.updateIfNeeded(other);
        assertEquals(2, underTest.getSize());
        assertEquals("a", underTest.nextGuess());
    }

    @Test
    public void shouldNotUpdateIfOtherResultIsWorse() {
        Map<List<LetterColor>, List<String>> currentBuckets = Map.of(
                List.of(LetterColor.GREY), List.of("a")
        );
        MiniMaxResult underTest = new MiniMaxResult("b", 1);
        Map<List<LetterColor>, List<String>> otherBuckets = Map.of(
                List.of(LetterColor.GREY), List.of("a", "b")
        );
        MiniMaxResult other = new MiniMaxResult("a", 2);
        underTest.updateIfNeeded(other);
        assertEquals(1, underTest.getSize());
        assertEquals("b", underTest.nextGuess());
    }

}