package john.mikael.gundersen.anagram;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class Anagram {
    private List<String> words;

    public Anagram(String... words) {
        this.words = new LinkedList<>(Arrays.asList(words));
    }

    public void add(String anagram) {
        words.add(anagram);
    }
}
