package wordle.communicator.console;

import wordle.communicator.GuessVerifier;

public class ConsoleGuessVerifier implements GuessVerifier {

    @Override
    public boolean isCorrect(String guess) {
        return guess.equals("22222");
    }

}
