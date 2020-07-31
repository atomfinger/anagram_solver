package john.mikael.gundersen.anagram;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AnagramPrintStreamWriter {

    private final AnagramPrintStream out;
    
    public void write(List<Anagram> anagrams) {
        anagrams.stream()
                .map(anagram -> String.join(" ", anagram.getWords()))
                .forEach(out::println);
    }
}
