package john.mikael.gundersen.anagram


import spock.lang.Specification

class AnagramPrintStreamWriterSpec extends Specification {

    AnagramPrintStream printStream = Mock()

    AnagramPrintStreamWriter writer

    def setup() {
        writer = new AnagramPrintStreamWriter(printStream)
    }

    def "must write out single word"() {
        given:
            def anagram = new Anagram("Apple")
        when:
            writer.write(Arrays.asList(anagram))
        then:
            1 * printStream.println("Apple")
    }

    def "must have space delimiter when multiple words exists"() {
        given:
            def anagram = new Anagram("Apple", "Elppa")
        when:
            writer.write(Arrays.asList(anagram))
        then:
            1 * printStream.println("Apple Elppa")
    }
}
