package wordle.communicator.console;

import wordle.communicator.InputOutput;

import java.util.Scanner;

public class ConsoleInputOutput implements InputOutput {

    private final Scanner scanner;

    public ConsoleInputOutput() {
        this.scanner = new Scanner(System.in);
    }


    @Override
    public String read() {
        return scanner.next();
    }

    @Override
    public void write(String s) {
        System.out.println(s);
    }
}
