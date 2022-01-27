package wordle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MiniMaxResultTest {

    @Test
    public void shouldUpdateIfResultNotSet() {
        MiniMaxResult underTest = new MiniMaxResult();
        MiniMaxResult other = new MiniMaxResult("a", 2);
        underTest.updateIfNeeded(other);
        assertEquals(2, underTest.getSize());
        assertEquals("a", underTest.getGuess());
    }

    @Test
    public void shouldUpdateIfOtherResultIsBetter() {
        MiniMaxResult underTest = new MiniMaxResult("b", 3);
        MiniMaxResult other = new MiniMaxResult("a", 2);
        underTest.updateIfNeeded(other);
        assertEquals(2, underTest.getSize());
        assertEquals("a", underTest.getGuess());
    }

    @Test
    public void shouldNotUpdateIfOtherResultIsWorse() {
        MiniMaxResult underTest = new MiniMaxResult("b", 1);
        MiniMaxResult other = new MiniMaxResult("a", 2);
        underTest.updateIfNeeded(other);
        assertEquals(1, underTest.getSize());
        assertEquals("b", underTest.getGuess());
    }

}