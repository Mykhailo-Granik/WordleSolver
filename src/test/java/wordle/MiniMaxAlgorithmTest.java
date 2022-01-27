package wordle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
        when(guessesProvider.provide()).thenReturn(List.of(onlyWord));
        when(answersProvider.provide()).thenReturn(List.of(onlyWord));
        assertEquals(
                new MiniMaxResult(
                        onlyWord,
                        1,
                        Map.of(List.of(GREEN, GREEN, GREEN, GREEN, GREEN), List.of(onlyWord))
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
                        1,
                        Map.of(
                                List.of(GREEN, GREEN, GREEN, GREEN, GREEN), List.of("aaaaa"),
                                List.of(GREY, GREY, GREY, GREY, GREY), List.of("bbbbb")
                        )
                ),
                underTest.calculate()
        );
    }

}