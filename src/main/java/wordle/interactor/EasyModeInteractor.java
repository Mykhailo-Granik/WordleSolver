package wordle.interactor;

import wordle.LetterColor;
import wordle.algorithms.Guess;
import wordle.algorithms.GuessCalculator;
import wordle.algorithms.minimax.FileGuessesProvider;
import wordle.algorithms.minimax.MiniMaxAlgorithm;
import wordle.dictionary.AnswersProvider;
import wordle.dictionary.FileAnswersProvider;
import wordle.dictionary.GuessesProvider;

import java.util.List;

public class EasyModeInteractor extends InteractorImpl {

    @Override
    public void processResponse(List<LetterColor> response) {
        answersProvider.update(guess.answersMatchingResponse(response));
    }

}
