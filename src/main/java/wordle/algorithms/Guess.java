package wordle.algorithms;

import wordle.LetterColor;

import java.util.List;

public interface Guess {

    String nextGuess();

    List<String> answersMatchingResponse(List<LetterColor> response);

}
