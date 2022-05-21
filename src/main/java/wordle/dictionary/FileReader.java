package wordle.dictionary;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class FileReader {

    private final String path;

    public List<String> read() {
        List<String> result = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            result = lines.collect(Collectors.toList());
        } catch (IOException e) {
            // TODO: handle the exception;
        }
        return result;
    }

}
