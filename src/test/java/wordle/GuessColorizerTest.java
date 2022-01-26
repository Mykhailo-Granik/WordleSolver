package wordle;

import org.junit.Test;
import wordle.GuessColorizer;
import wordle.LetterColor;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static wordle.LetterColor.*;

public class GuessColorizerTest {

    @Test
    public void shouldReturnAllGreyWhenLettersDontMatch() {
        assertEquals(
                List.of(GREY, GREY, GREY, GREY, GREY),
                new GuessColorizer("aaaaa").colorize("bbbbb")
        );
    }

    @Test
    public void shouldReturnAllGreenWhenAllLettersMatch() {
        assertEquals(
                List.of(GREEN, GREEN, GREEN, GREEN, GREEN),
                new GuessColorizer("aaaaa").colorize("bbbbb")
        );
    }

    @Test
    public void shouldReturnOneGreenWhenOneLetterIsOnCorrectPosition() {
        assertEquals(
                List.of(GREY, GREEN, GREY, GREY, GREY),
                new GuessColorizer("aaaaa").colorize("babbb")
        );
    }

    @Test
    public void shouldReturnOneYellowWhenOneLetterIsOnIncorrectPosition() {
        assertEquals(
                List.of(GREY, YELLOW, GREY, GREY, GREY),
                new GuessColorizer("abcde").colorize("fafff")
        );
    }

    @Test
    public void shouldReturnGreenAndYellowWhenOneLetterIsOnCorrectPositionAndOtherIsNot() {
        assertEquals(
                List.of(GREY, GREEN, GREY, GREY, YELLOW),
                new GuessColorizer("accaa").colorize("bcbbc")
        );
    }

    @Test
    public void shouldReturnTwoGreensWhenTwoLettersAreOnCorrectPositions() {
        assertEquals(
                List.of(GREY, GREY, GREY, GREEN, GREEN),
                new GuessColorizer("aaacc").colorize("bbbcc")
        );
    }

    @Test
    public void shouldReturnTwoGYellowsWhenTwoLettersAreOnIncorrectPositions() {
        assertEquals(
                List.of(GREY, GREY, GREY, YELLOW, YELLOW),
                new GuessColorizer("cacaa").colorize("bbbcc")
        );
    }

    @Test
    public void shouldWorkOnRandomTest() {
        assertEquals(
                List.of(GREY, GREY, GREY, GREEN, YELLOW),
                new GuessColorizer("world").colorize("hello")
        );
    }

}