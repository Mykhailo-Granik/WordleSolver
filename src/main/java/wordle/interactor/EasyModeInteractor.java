package wordle.interactor;

import wordle.colorizing.LetterColor;

import java.util.List;

public class EasyModeInteractor extends InteractorImpl {

    @Override
    public void processResponse(List<LetterColor> response) {
        answersProvider.update(answersMatchingResponse(response));
    }

}
