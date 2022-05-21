package wordle.communicator;

import wordle.colorizing.LetterColor;

import java.util.List;

public interface InputParser {

    List<LetterColor> parse(String input);

}
