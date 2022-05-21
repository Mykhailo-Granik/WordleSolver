package wordle.interactor;

import wordle.colorizing.LetterColor;

import java.util.List;

public interface Interactor {

    String guess();

    void processResponse(List<LetterColor> response);

}
