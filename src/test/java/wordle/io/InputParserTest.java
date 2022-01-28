package wordle.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wordle.LetterColor;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static wordle.LetterColor.*;

public class InputParserTest {

    private InputParser underTest;

    @BeforeEach
    public void setup() {
        underTest = new InputParser();
    }

    @Test
    public void shouldReturnEmptyListForEmptyInput() {
        assertEquals(Collections.emptyList(), underTest.parse(""));
    }

    @Test
    public void shouldParseAllZeroes() {
        assertEquals(
                List.of(GREY, GREY, GREY, GREY, GREY),
                underTest.parse("00000")
        );
    }

    @Test
    public void shouldParseAllOnes() {
        assertEquals(
                List.of(YELLOW, YELLOW, YELLOW, YELLOW, YELLOW),
                underTest.parse("11111")
        );
    }

    @Test
    public void shouldParseAllTwos() {
        assertEquals(
                List.of(GREEN, GREEN, GREEN, GREEN, GREEN),
                underTest.parse("22222")
        );
    }

    @Test
    public void shouldParseCombinationOfNumbers() {
        assertEquals(
                List.of(GREY, YELLOW, GREEN, GREEN, YELLOW),
                underTest.parse("01221")
        );
    }

}