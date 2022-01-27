package wordle;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BucketsGeneratorTest {

    public static final String ANSWER = "aaaaa";
    @Mock
    private AnswersProvider answersProvider;
    private BucketsGenerator underTest;

    @BeforeEach
    public  void setup() {
        GuessColorizer guessColorizer = new GuessColorizer(ANSWER);
        underTest = new BucketsGenerator(
                answersProvider,
                guessColorizer
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

}