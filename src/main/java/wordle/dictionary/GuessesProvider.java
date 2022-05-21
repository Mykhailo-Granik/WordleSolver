package wordle.dictionary;

import wordle.colorizing.LetterColor;

import java.util.List;

public interface GuessesProvider {

    List<String> provide();

    void update(List<String> updated);

}
