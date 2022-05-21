package wordle.communicator.console;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsoleGuessVerifierTest {

    @Test
    public void shouldVerifyCorrectGuess() {
        assertTrue(new ConsoleGuessVerifier().isCorrect("22222"));
    }

    @Test
    public void shouldNotVerifyIncorrectGuess() {
        assertFalse(new ConsoleGuessVerifier().isCorrect("11111"));
        assertFalse(new ConsoleGuessVerifier().isCorrect("00000"));
        assertFalse(new ConsoleGuessVerifier().isCorrect("2222"));
        assertFalse(new ConsoleGuessVerifier().isCorrect("222222"));
        assertFalse(new ConsoleGuessVerifier().isCorrect("22122"));
    }

}