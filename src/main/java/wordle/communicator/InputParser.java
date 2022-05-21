package wordle.communicator;

import wordle.LetterColor;

import java.util.List;

public interface InputParser {

    List<LetterColor> parse(String input);

}
