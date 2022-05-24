package wordle.communicator;

import lombok.AllArgsConstructor;
import wordle.communicator.GuessVerifier;
import wordle.communicator.InputOutput;
import wordle.communicator.InputParser;
import wordle.communicator.Communicator;
import wordle.interactor.Interactor;

import java.util.Scanner;

@AllArgsConstructor
public class CommunicatorImpl implements Communicator {

    private final Interactor interactor;
    private final InputParser inputParser;
    private final GuessVerifier guessVerifier;
    private final InputOutput inputOutput;

    @Override
    public void communicate() {
        while (true) {
            inputOutput.write(interactor.guess());
            String response = inputOutput.read();
            if (guessVerifier.isCorrect(response)) {
                break;
            }
            interactor.processResponse(inputParser.parse(response));
        }
    }

}
