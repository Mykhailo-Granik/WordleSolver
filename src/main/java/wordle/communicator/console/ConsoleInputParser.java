package wordle.communicator.console;

import wordle.LetterColor;
import wordle.communicator.InputParser;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleInputParser implements InputParser {

    @Override
    public List<LetterColor> parse(String input) {
        return input.chars()
                .mapToObj(value -> value - '0')
                .map(LetterColor::fromNumber)
                .collect(Collectors.toList());
    }

}
