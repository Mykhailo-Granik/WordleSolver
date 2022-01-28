package wordle;

import java.util.List;

public class FileGuessesProvider implements GuessesProvider {

    private static final String GUESSES_PATH = "C:\\Users\\Fcdkb\\OneDrive\\Files\\Wordle\\guesses.txt";
    private List<String> guesses;

    public FileGuessesProvider() {
        guesses = new FileReader(GUESSES_PATH).read();
        guesses.addAll(new FileReader(FileAnswersProvider.PATH).read());
    }

    @Override
    public List<String> provide() {
        return guesses;
    }

}
