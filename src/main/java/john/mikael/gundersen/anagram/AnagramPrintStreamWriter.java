package john.mikael.gundersen.anagram;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AnagramPrintStreamWriter implements AnagramWriter {

    private final AnagramPrintStream out;

    @Override
    public void write(List<Anagram> anagrams) {
        anagrams.stream()
                .map(anagram -> String.join(" ", anagram.getWords()))
                .forEach(out::println);
    }
}
