package wordle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static wordle.LetterColor.*;

public class WordsMatcherTest {

    @Test
    public void greenLetterOnSamePositionsAreOk() {
        WordsMatcher wordsMatcher = new WordsMatcher("abcde", "aaaaa", List.of(GREEN, GREY, GREY, GREY, GREY));
        assertTrue(wordsMatcher.match());
    }

    @Test
    public void greenLetterOnDifferentPositionsAreNotOk() {
        WordsMatcher wordsMatcher = new WordsMatcher("abcde", "ghija", List.of(GREEN, GREY, GREY, GREY, GREY));
        assertFalse(wordsMatcher.match());
    }

    @Test
    public void yellowLetterOnSamePositionsAreNotOk() {
        WordsMatcher wordsMatcher = new WordsMatcher("abcde", "aghij", List.of(YELLOW, GREY, GREY, GREY, GREY));
        assertFalse(wordsMatcher.match());
    }

    @Test
    public void yellowLetterOnDifferentPositionsAreOk() {
        WordsMatcher wordsMatcher = new WordsMatcher("abcde", "ghija", List.of(YELLOW, GREY, GREY, GREY, GREY));
        assertTrue(wordsMatcher.match());
    }

    @Test
    public void sameYellowAndGreyLetterInTheWordHandledProperly() {
        WordsMatcher wordsMatcher = new WordsMatcher("aacde", "ghiaa", List.of(YELLOW, GREY, GREY, GREY, GREY));
        assertFalse(wordsMatcher.match());
    }

    @Test
    public void greyLettersShouldBeAbsentInNextGuess() {
        WordsMatcher wordsMatcher = new WordsMatcher("abcde", "ghiba", List.of(YELLOW, GREY, GREY, GREY, GREY));
        assertFalse(wordsMatcher.match());
    }

    @Test
    public void realWorldTest1() {
        WordsMatcher wordsMatcher = new WordsMatcher("aesir", "canto", List.of(YELLOW, GREY, GREY, GREY, YELLOW));
        assertFalse(wordsMatcher.match());
    }

}