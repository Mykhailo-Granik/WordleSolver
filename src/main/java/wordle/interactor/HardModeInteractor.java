package wordle.interactor;

import wordle.LetterColor;

import java.util.List;

public class HardModeInteractor extends InteractorImpl {

    @Override
    public void processResponse(List<LetterColor> response) {
        answersProvider.update(guess.answersMatchingResponse(response));
        guessesProvider.update(guess.nextGuess(), response);
    }
}
