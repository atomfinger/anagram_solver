package john.mikael.gundersen.anagram

import spock.lang.Specification

class AnagramSpec extends Specification {

    def "when nothing is passed to the constructor the constructor must create an empty word list"() {
        expect:
            new Anagram().words.isEmpty()
    }

    def "must be able to add words after initializing the anagram"() {
        when:
            def anagram = new Anagram("Apple")
            anagram.add("Elppa")
        then:
            anagram.words.containsAll("Apple", "Elppa")
    }
}
