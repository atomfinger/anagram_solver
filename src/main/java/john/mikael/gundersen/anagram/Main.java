package john.mikael.gundersen.anagram;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("No file parameter given");
            return;
        }
        new Main().run(args[0]);
    }

    @SneakyThrows
    public void run(String uri) {
        val words = getWordsFromFile(uri);
        val anagrams = generateAnagramMap(words);
        anagrams.values().stream()
                .map(anagramWords -> String.join(" ", anagramWords))
                .forEach(System.out::println);
    }

    @SneakyThrows
    private List<String> getWordsFromFile(String uri) {
        try (Stream<String> stream = Files.lines(Paths.get(uri))) {
            return stream.filter(word -> !word.isEmpty() && !word.isBlank()).collect(Collectors.toList());
        }
    }

    private Map<String, List<String>> generateAnagramMap(List<String> words) {
        val wordMap = new HashMap<String, List<String>>();
        for (val word : words) {
            val key = findKeyBasedOnWord(word);
            if (!wordMap.containsKey(key))
                wordMap.put(key, new LinkedList<>());
            wordMap.get(key).add(word);
        }
        return wordMap;
    }

    private String findKeyBasedOnWord(String word) {
        val charArray = word.toLowerCase().toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}
