package wordle;

import org.junit.jupiter.api.Test;
import wordle.colorizing.LetterColor;

import static org.junit.jupiter.api.Assertions.*;

public class LetterColorTest {

    @Test
    public void parsingFromNumberCodeShouldReturnGreyForZero() {
        assertEquals(LetterColor.GREY, LetterColor.fromNumber(0));
    }

    @Test
    public void parsingFromNumberCodeShouldReturnYellowForOne() {
        assertEquals(LetterColor.YELLOW, LetterColor.fromNumber(1));
    }

    @Test
    public void parsingFromNumberCodeShouldReturnGreenForTwo() {
        assertEquals(LetterColor.GREEN, LetterColor.fromNumber(2));
    }

    @Test
    public void parsingFromNumberCodeShouldThrowForOtherNumbers() {
        assertThrows(RuntimeException.class, () -> LetterColor.fromNumber(3));
    }

}