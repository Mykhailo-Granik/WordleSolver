package wordle.interactor;

import wordle.LetterColor;

import java.util.List;

public interface Interactor {

    String guess();

    void processResponse(List<LetterColor> response);

}
