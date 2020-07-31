package john.mikael.gundersen.anagram;

import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordSortAnagramMatcher implements AnagramMatcher {

    public List<Anagram> findAnagrams(List<String> words) {
        val wordMap = new HashMap<String, Anagram>();
        for (val word : words) {
            val key = findKeyBasedOnWord(word);
            if (!wordMap.containsKey(key))
                wordMap.put(key, new Anagram());
            wordMap.get(key).add(word);
        }
        return new ArrayList<>(wordMap.values());
    }

    private String findKeyBasedOnWord(String word) {
        val charArray = word.toLowerCase().toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}
