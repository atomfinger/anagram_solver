package john.mikael.gundersen.anagram;

import java.util.List;

public interface AnagramMatcher {
    List<List<String>> findAnagrams(List<String> words);
}
