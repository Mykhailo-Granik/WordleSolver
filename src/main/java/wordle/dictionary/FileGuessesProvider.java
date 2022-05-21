package wordle.dictionary;

import wordle.colorizing.LetterColor;
import wordle.colorizing.HardModeWordsMatcher;

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
    public void update(List<String> updatedGuesses) {
        guesses = updatedGuesses;
    }

}
