package wordle;

import org.junit.jupiter.api.Test;
import wordle.colorizing.HardModeWordsMatcher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static wordle.colorizing.LetterColor.*;

public class HardModeWordsMatcherTest {

    @Test
    public void greenLetterOnSamePositionsAreOk() {
        HardModeWordsMatcher wordsMatcher = new HardModeWordsMatcher("abcde", "aaaaa", List.of(GREEN, GREY, GREY, GREY, GREY));
        assertTrue(wordsMatcher.match());
    }

    @Test
    public void greenLetterOnDifferentPositionsAreNotOk() {
        HardModeWordsMatcher wordsMatcher = new HardModeWordsMatcher("abcde", "ghija", List.of(GREEN, GREY, GREY, GREY, GREY));
        assertFalse(wordsMatcher.match());
    }

    @Test
    public void yellowLetterOnSamePositionsAreNotOk() {
        HardModeWordsMatcher wordsMatcher = new HardModeWordsMatcher("abcde", "aghij", List.of(YELLOW, GREY, GREY, GREY, GREY));
        assertFalse(wordsMatcher.match());
    }

    @Test
    public void yellowLetterOnDifferentPositionsAreOk() {
        HardModeWordsMatcher wordsMatcher = new HardModeWordsMatcher("abcde", "ghija", List.of(YELLOW, GREY, GREY, GREY, GREY));
        assertTrue(wordsMatcher.match());
    }

    @Test
    public void sameYellowAndGreyLetterInTheWordHandledProperly() {
        HardModeWordsMatcher wordsMatcher = new HardModeWordsMatcher("aacde", "ghiaa", List.of(YELLOW, GREY, GREY, GREY, GREY));
        assertFalse(wordsMatcher.match());
    }

    @Test
    public void greyLettersShouldBeAbsentInNextGuess() {
        HardModeWordsMatcher wordsMatcher = new HardModeWordsMatcher("abcde", "ghiba", List.of(YELLOW, GREY, GREY, GREY, GREY));
        assertFalse(wordsMatcher.match());
    }

    @Test
    public void realWorldTest1() {
        HardModeWordsMatcher wordsMatcher = new HardModeWordsMatcher("aesir", "canto", List.of(YELLOW, GREY, GREY, GREY, YELLOW));
        assertFalse(wordsMatcher.match());
    }

}