package wordle.main;

import wordle.communicator.Communicator;
import wordle.communicator.CommunicatorImpl;
import wordle.communicator.console.ConsoleGuessVerifier;
import wordle.communicator.console.ConsoleInputOutput;
import wordle.communicator.console.ConsoleInputParser;
import wordle.interactor.InteractorFactory;

public class WordleMain {

    public static void main(String[] args) {
        userCommunicator().communicate();
    }

    private static Communicator userCommunicator() {
        return new CommunicatorImpl(
                new InteractorFactory().create(),
                new ConsoleInputParser(),
                new ConsoleGuessVerifier(),
                new ConsoleInputOutput()
        );
    }

}
