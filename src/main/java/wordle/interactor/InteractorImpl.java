package wordle.interactor;

import lombok.RequiredArgsConstructor;
import wordle.LetterColor;
import wordle.algorithms.Guess;
import wordle.algorithms.GuessCalculator;
import wordle.algorithms.minimax.BucketsGenerator;
import wordle.algorithms.minimax.FileGuessesProvider;
import wordle.algorithms.minimax.MiniMaxAlgorithm;
import wordle.dictionary.AnswersProvider;
import wordle.dictionary.FileAnswersProvider;
import wordle.dictionary.GuessesProvider;

import java.util.List;

public abstract class InteractorImpl implements Interactor {

    protected final AnswersProvider answersProvider;
    protected final GuessesProvider guessesProvider;
    protected final GuessCalculator guessCalculator;
    protected Guess guess;

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
    public abstract void processResponse(List<LetterColor> response);

    protected List<String> answersMatchingResponse(List<LetterColor> response) {
        return new BucketsGenerator(guess.nextGuess(), answersProvider)
                .bucketForResponse(response);
    }

}
