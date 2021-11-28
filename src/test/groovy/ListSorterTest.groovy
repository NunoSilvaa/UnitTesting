import com.aor.numbers.ListSorter
import spock.lang.Specification

class ListSorterTest extends Specification{
    def 'Sort'(){
        given:
        def list = Arrays.asList(3, 2, 6, 1, 4, 5, 7)
        def expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7)

        when:
        ListSorter sorter = new ListSorter()
        def sorted = sorter.sort(list)

        then:
        expected == sorted
    }

    def 'bug_sort_8276'(){
        when:
        ListSorter sorter = new ListSorter()
        def sorted = sorter.sort(Arrays.asList(1, 2, 4, 2))

        then:
        Arrays.asList(1, 2, 2, 4) == sorted
    }
}
