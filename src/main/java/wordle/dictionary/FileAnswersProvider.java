package wordle.dictionary;

import java.util.List;

public class FileAnswersProvider implements AnswersProvider {

    public static final String PATH = "C:\\Users\\Fcdkb\\OneDrive\\Files\\Wordle\\answers.txt";

    private List<String> answers;

    public FileAnswersProvider() {
        answers = new FileReader(PATH).read();
    }

    @Override
    public List<String> provide() {
       return answers;
    }

    @Override
    public void update(List<String> answers) {
        this.answers = answers;
    }

}
