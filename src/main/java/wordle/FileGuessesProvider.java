package wordle;

import java.util.List;

public class FileGuessesProvider implements GuessesProvider {

    @Override
    public List<String> provide() {
        FileReader fileReader = new FileReader("C:\\Users\\Fcdkb\\OneDrive\\Files\\Wordle\\guesses.txt");
        List<String> result = fileReader.read();
        result.addAll(new FileAnswersProvider().provide());
        return result;
    }

}
