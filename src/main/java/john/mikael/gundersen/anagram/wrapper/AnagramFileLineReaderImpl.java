package john.mikael.gundersen.anagram.wrapper;

import john.mikael.gundersen.anagram.FileLineReader;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Files is a public final class, so making tests for it is difficult. To make it easier the required functionality of
 * Files has been wrapped in this class so that we can mock and verify the functionality of our application.
 */
public class AnagramFileLineReaderImpl implements FileLineReader {
    @Override
    @SneakyThrows
    public Stream<String> lines(Path path) {
        return Files.lines(path);
    }
}
