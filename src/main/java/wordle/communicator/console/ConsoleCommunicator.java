package wordle.communicator.console;

import lombok.AllArgsConstructor;
import wordle.communicator.GuessVerifier;
import wordle.communicator.InputParser;
import wordle.communicator.UserCommunicator;
import wordle.interactor.Interactor;

import java.util.Scanner;

@AllArgsConstructor
public class ConsoleCommunicator implements UserCommunicator {

    private final Interactor interactor;
    private final InputParser inputParser;
    private final GuessVerifier guessVerifier;

    @Override
    public void communicate() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(interactor.guess());
            String response = scanner.next();
            if (guessVerifier.isCorrect(response)) {
                break;
            }
            interactor.processResponse(inputParser.parse(response));
        }
    }

}
