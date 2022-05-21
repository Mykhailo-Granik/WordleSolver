package wordle.algorithms.minimax;

import wordle.GuessColorizer;
import wordle.LetterColor;
import wordle.WordsMatcher;
import wordle.dictionary.FileAnswersProvider;
import wordle.dictionary.FileReader;
import wordle.dictionary.GuessesProvider;

import java.util.List;
import java.util.stream.Collectors;

public class FileGuessesProvider implements GuessesProvider {

    private static final String GUESSES_PATH = "C:\\Users\\Fcdkb\\OneDrive\\Files\\Wordle\\guesses.txt";
    private List<String> guesses;

    public FileGuessesProvider() {
        guesses = new FileReader(GUESSES_PATH).read();
        guesses.addAll(new FileReader(FileAnswersProvider.PATH).read());
        guesses = guesses.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<String> provide() {
        return guesses;
    }

    @Override
    public void update(String guess, List<LetterColor> response) {
        guesses = guesses.stream()
                .filter(currentGuess -> new WordsMatcher(guess, currentGuess, response).match())
                .collect(Collectors.toList());
    }

}
