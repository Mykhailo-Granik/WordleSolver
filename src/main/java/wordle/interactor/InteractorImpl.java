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

public class InteractorImpl implements Interactor {

    private AnswersProvider answersProvider;
    private GuessesProvider guessesProvider;
    private GuessCalculator guessCalculator;
    private Guess guess;

    public InteractorImpl() {
        answersProvider = new FileAnswersProvider();
        guessesProvider = new FileGuessesProvider();
        guessCalculator = new MiniMaxAlgorithm(guessesProvider, answersProvider);
    }

    @Override
    public String guess() {
        guess = guessCalculator.calculate();
        return guess.nextGuess();
    }

    @Override
    public void processResponse(List<LetterColor> response) {
        answersProvider.update(guess.answersMatchingResponse(response));
    }
}
