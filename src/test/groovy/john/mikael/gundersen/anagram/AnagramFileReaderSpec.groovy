package john.mikael.gundersen.anagram

import spock.lang.Specification

import java.nio.file.Paths
import java.util.stream.Stream

class AnagramFileReaderSpec extends Specification {
    AnagramMatcher anagramMatcher = Mock()
    FileLineReader lineReader = Mock()
    AnagramFileReader fileReader

    def setup() {
        fileReader = new AnagramFileReader(anagramMatcher, lineReader)
    }

    def "when file has words then anagramFileReader must return anagrams"() {
        given:
            def path = Paths.get("something")
            lineReader.lines(path) >> Stream.of("apple", "pear")
            anagramMatcher.findAnagrams(Arrays.asList("apple", "pear")) >> Arrays.asList(
                    new Anagram("apple"),
                    new Anagram("pear")
            )
        when:
            def result = fileReader.parseFile("something")
        then:
            result == Arrays.asList(new Anagram("apple"), new Anagram("pear"))
    }

    def "must ignore empty lines"() {
        given:
            def path = Paths.get("something")
            lineReader.lines(path) >> Stream.of("apple", "    ", "", "pear")
            anagramMatcher.findAnagrams(Arrays.asList("apple", "pear")) >> Arrays.asList(
                    new Anagram("apple"),
                    new Anagram("pear")
            )
        when:
            def result = fileReader.parseFile("something")
        then:
            result == Arrays.asList(new Anagram("apple"), new Anagram("pear"))
    }
}
