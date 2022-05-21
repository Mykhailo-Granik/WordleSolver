package wordle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wordle.algorithms.minimax.MiniMaxAlgorithm;
import wordle.algorithms.minimax.MiniMaxResult;
import wordle.dictionary.AnswersProvider;
import wordle.dictionary.GuessesProvider;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static wordle.LetterColor.*;

@ExtendWith(MockitoExtension.class)
public class MiniMaxAlgorithmTest {

    @Mock
    private GuessesProvider guessesProvider;
    @Mock
    private AnswersProvider answersProvider;
    private MiniMaxAlgorithm underTest;


    @BeforeEach
    public void setup() {
        underTest = new MiniMaxAlgorithm(
                guessesProvider,
                answersProvider
        );
    }

    @Test
    public void whenThereIsOnlyOnePossibleAnswerResultShouldIndicateIt() {
        String onlyWord = "aaaaa";
        when(answersProvider.provide()).thenReturn(List.of(onlyWord));
        assertEquals(
                new MiniMaxResult(
                        onlyWord,
                        1
                ),
                underTest.calculate()
        );
    }

    @Test
    public void whenThereAreSeveralPossibleAnswersOptimalOneShouldBeChosen() {
        when(guessesProvider.provide()).thenReturn(List.of("aaaaa", "bbbbb", "ccccc"));
        when(answersProvider.provide()).thenReturn(List.of("aaaaa", "bbbbb"));
        assertEquals(
                new MiniMaxResult(
                        "aaaaa",
                        1
                ),
                underTest.calculate()
        );
    }

}