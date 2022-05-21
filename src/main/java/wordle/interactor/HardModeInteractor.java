package wordle.interactor;

import wordle.colorizing.HardModeWordsMatcher;
import wordle.colorizing.LetterColor;

import java.util.List;
import java.util.stream.Collectors;

public class HardModeInteractor extends InteractorImpl {

    @Override
    public void processResponse(List<LetterColor> response) {
        answersProvider.update(answersMatchingResponse(response));
        guessesProvider.update(updatedGuesses(response));
    }

    private List<String> updatedGuesses(List<LetterColor> response) {
        return guessesProvider.provide().stream()
                .filter(currentGuess -> new HardModeWordsMatcher(guess.nextGuess(), currentGuess, response).match())
                .collect(Collectors.toList());
    }
}
