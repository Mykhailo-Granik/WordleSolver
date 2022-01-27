package wordle;

import java.util.List;

public class FileAnswersProvider implements AnswersProvider {

    @Override
    public List<String> provide() {
        FileReader fileReader = new FileReader("C:\\Users\\Fcdkb\\OneDrive\\Files\\Wordle\\answers.txt");
        return fileReader.read();
    }

}
