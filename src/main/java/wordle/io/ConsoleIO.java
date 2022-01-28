package wordle.io;

import wordle.interactor.Interactor;
import wordle.interactor.InteractorImpl;

import java.util.Scanner;

public class ConsoleIO {

    public void run() {
        Interactor interactor = new InteractorImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(interactor.guess());
            String response = scanner.next();
            if (correctGuess(response)) {
                break;
            }
            interactor.processResponse(new InputParser().parse(response));
        }
    }

    private boolean correctGuess(String input) {
        return input.equals("22222");
    }

    public static void main(String[] args) {
        new ConsoleIO().run();
    }

}
