import com.aor.numbers.GenericListFilter
import com.aor.numbers.ListFilterer
import spock.lang.Specification

class ListFilteredTest extends Specification{
    def 'filter'(){
        given:
        GenericListFilter filter = Mock(GenericListFilter.class)
        filter.accept(1) >> true
        filter.accept(2) >> false
        filter.accept(3) >> true
        filter.accept(4) >> false
        filter.accept(5) >> true

        when:
        def filterer = new ListFilterer(filter)

        then:
        Arrays.asList(1, 3, 5) == filterer.filter(Arrays.asList(1, 2, 3, 4, 5))
    }
}
