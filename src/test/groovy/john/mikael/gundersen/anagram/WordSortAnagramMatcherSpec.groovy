package john.mikael.gundersen.anagram

import spock.lang.Specification

class WordSortAnagramMatcherSpec extends Specification {

    def anagramMatcher = new WordSortAnagramMatcher()

    def 'list of single items returned when no anagrams in list'() {
        given:
            def words = ["apple", "pear", "orange"]
        when:
            def result = anagramMatcher.findAnagrams(words)
        then:
            result.containsAll(new Anagram("apple"), new Anagram("pear"), new Anagram("orange"))
    }

    def 'list of anagrams should be grouped together'() {
        given:
            def words = ["apple", "aplpe", "elppa"]
        when:
            def result = anagramMatcher.findAnagrams(words)
        then:
            result == [new Anagram("apple", "aplpe", "elppa")]
    }

    def 'list of different words where some are anagrams must bundle those anagrams together'() {
        given:
            def words = ["apple", "pear", "elppa"]
        when:
            def result = anagramMatcher.findAnagrams(words)
        then:
            result.containsAll(new Anagram("pear"), new Anagram("apple", "elppa"))
    }

    def "must be able to match lower and upper case characters"() {
        given:
            def words = ["APPLE", "apple", "elPPa"]
        when:
            def result = anagramMatcher.findAnagrams(words)
        then:
            result.contains(new Anagram("APPLE", "apple", "elPPa"))
    }
}
