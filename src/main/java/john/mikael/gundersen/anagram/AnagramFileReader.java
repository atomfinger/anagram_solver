package john.mikael.gundersen.anagram;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class AnagramFileReader {

    private final AnagramMatcher anagramMatcher;
    private final FileLineReader lineReader;

    public List<Anagram> parseFile(String uri) {
        val words = getWords(uri);
        return anagramMatcher.findAnagrams(words);
    }

    @SneakyThrows
    private List<String> getWords(String uri) {
        try (Stream<String> stream = lineReader.lines(Paths.get(uri))) {
            return stream.filter(word -> !word.isEmpty() && !word.isBlank()).collect(Collectors.toList());
        }
    }
}
