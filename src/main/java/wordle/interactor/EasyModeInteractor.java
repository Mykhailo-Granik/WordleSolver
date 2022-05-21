package wordle.interactor;

import wordle.LetterColor;

import java.util.List;

public class EasyModeInteractor extends InteractorImpl {

    @Override
    public void processResponse(List<LetterColor> response) {
        answersProvider.update(answersMatchingResponse(response));
    }

}
