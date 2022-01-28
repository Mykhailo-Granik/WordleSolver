package wordle.io;

import wordle.interactor.HardModeInteractor;
import wordle.interactor.Interactor;
import wordle.interactor.EasyModeInteractor;

import java.util.Scanner;

public class ConsoleIO {

    public void run() {
        Interactor interactor = new HardModeInteractor();
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
