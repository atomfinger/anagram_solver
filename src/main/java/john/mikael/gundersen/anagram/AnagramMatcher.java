package john.mikael.gundersen.anagram;

import java.util.List;

public interface AnagramMatcher {
    List<Anagram> findAnagrams(List<String> words);
}
