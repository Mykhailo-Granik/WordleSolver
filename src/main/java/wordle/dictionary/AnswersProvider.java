package wordle.dictionary;

import java.util.List;

public interface AnswersProvider {

    List<String> provide();

    void update(List<String> answers);

}
