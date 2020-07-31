package john.mikael.gundersen.anagram;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileLineReader {
    Stream<String> lines(Path path);
}
