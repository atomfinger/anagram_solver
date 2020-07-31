package john.mikael.gundersen.anagram.wrapper;

import john.mikael.gundersen.anagram.AnagramPrintStream;
import lombok.AllArgsConstructor;

import java.io.PrintStream;

/**
 * Since PrintStream is a class rather than interface, and due to this application only requiring the println
 * functionality (for now) I decided to wrap the stream in a class. This makes writing tests easier and
 * Allows us to mock interactions without having to resort to more invasive techniques such as manipulating classes
 * during runtime.
 */
@AllArgsConstructor
public class AnagramPrintStreamImpl implements AnagramPrintStream {

    private final PrintStream out;

    @Override
    public void println(String toPrint) {
        out.println(toPrint);
    }
}
