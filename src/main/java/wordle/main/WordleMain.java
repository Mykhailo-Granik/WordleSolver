package wordle.main;

import wordle.communicator.UserCommunicator;
import wordle.communicator.console.ConsoleCommunicator;
import wordle.communicator.console.ConsoleGuessVerifier;
import wordle.communicator.console.ConsoleInputParser;
import wordle.interactor.InteractorFactory;

public class WordleMain {

    public static void main(String[] args) {
        userCommunicator().communicate();
    }

    private static UserCommunicator userCommunicator() {
        return new ConsoleCommunicator(
                new InteractorFactory().create(),
                new ConsoleInputParser(),
                new ConsoleGuessVerifier()
        );
    }

}
