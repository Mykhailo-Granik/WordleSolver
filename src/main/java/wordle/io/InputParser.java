package wordle.io;

import wordle.LetterColor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public List<LetterColor> parse(String input) {
        return input.chars()
                .mapToObj(value -> value - '0')
                .map(LetterColor::fromNumber)
                .collect(Collectors.toList());
    }

}
