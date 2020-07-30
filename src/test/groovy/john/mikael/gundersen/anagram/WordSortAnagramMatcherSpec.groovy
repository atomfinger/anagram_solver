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
            result.flatten() == ["pear", "orange", "apple"]
    }

    def 'list of anagrams should be in the same list'() {
        given:
            def words = ["apple", "aplpe", "elppa"]
        when:
            def result = anagramMatcher.findAnagrams(words)
        then:
            result == [["apple", "aplpe", "elppa"]]
    }

    def 'list of different words where some are anagrams must bundle those anagrams together'() {
        given:
            def words = ["apple", "pear", "elppa"]
        when:
            def result = anagramMatcher.findAnagrams(words)
        then:
            result == [["pear"], ["apple", "elppa"]]
    }
}
