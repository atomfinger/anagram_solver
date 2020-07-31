package john.mikael.gundersen.anagram;

import john.mikael.gundersen.anagram.wrapper.AnagramFileLineReaderImpl;
import john.mikael.gundersen.anagram.wrapper.AnagramPrintStreamImpl;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;

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

    public void run(String filePath) {
        val reader = getReader();
        val writer = getWriter();
        val anagrams = reader.parseFile(filePath);
        writer.write(anagrams);
    }

    private AnagramFileReader getReader() {
        val matcher = new WordSortAnagramMatcher();
        val lineReader = new AnagramFileLineReaderImpl();
        return new AnagramFileReader(matcher, lineReader);
    }

    private AnagramWriter getWriter() {
        val printStream = new AnagramPrintStreamImpl(System.out);
        return new AnagramPrintStreamWriter(printStream);
    }
}
