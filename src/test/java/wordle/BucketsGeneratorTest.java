package wordle;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wordle.algorithms.minimax.BucketsGenerator;
import wordle.dictionary.AnswersProvider;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static wordle.LetterColor.*;

@ExtendWith(MockitoExtension.class)
public class BucketsGeneratorTest {

    public static final String GUESS = "aaaaa";
    @Mock
    private AnswersProvider answersProvider;
    private BucketsGenerator underTest;

    @BeforeEach
    public  void setup() {
        underTest = new BucketsGenerator(
                GUESS,
                answersProvider
        );
    }

    @Test
    public void whenThereIsOnlyOneGuessAvailableShouldGenerateOneBucket() {
        when(answersProvider.provide()).thenReturn(List.of("bbbbb"));
        assertEquals(1, underTest.generate().size());
    }

    @Test
    public void whenTwoGuessesFallInTheSameBucketShouldGenerateOneBucket() {
        when(answersProvider.provide()).thenReturn(List.of("bbbbb", "ccccc"));
        assertEquals(1, underTest.generate().size());
    }

    @Test
    public void whenTwoGuessesFallInDifferentBucketsShouldGenerateTwoBuckets() {
        when(answersProvider.provide()).thenReturn(List.of("bbbbb", "acccc"));
        assertEquals(2, underTest.generate().size());
    }

    @Test
    public void whenThreeGuessesFallInTwoBucketsShouldGenerateTwoBuckets() {
        when(answersProvider.provide()).thenReturn(List.of("bbbbb", "acccc", "adddd"));
        assertEquals(2, underTest.generate().size());
    }

    @Test
    public void shouldCorrectlyReturnBucketForResponse() {
        when(answersProvider.provide()).thenReturn(List.of("bbbbb", "acccc"));
        assertEquals(
                List.of("acccc"),
                underTest.bucketForResponse(
                        List.of(GREEN, GREY, GREY, GREY, GREY)
                )
        );
    }

    @Test
    public void shouldReturnEmptyBucketForMissingResponse() {
        when(answersProvider.provide()).thenReturn(List.of("bbbbb", "acccc"));
        assertEquals(
                Collections.emptyList(),
                underTest.bucketForResponse(
                        List.of(GREEN, GREEN, GREY, YELLOW, GREY)
                )
        );
    }

}