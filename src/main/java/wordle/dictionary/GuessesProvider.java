package wordle.dictionary;

import wordle.LetterColor;

import java.util.List;

public interface GuessesProvider {

    List<String> provide();

    void update(String guess, List<LetterColor> response);

}
