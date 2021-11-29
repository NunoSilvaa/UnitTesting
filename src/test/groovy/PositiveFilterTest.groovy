import com.aor.numbers.PositiveFilter
import spock.lang.Specification

class PositiveFilterTest extends Specification{
    def 'accept'(){
        given:
        def positives = Arrays.asList(1, 2, 3, 70, 200, 4682)
        def notPositives = Arrays.asList(0, -1, -2, -3, -70, -200, -4682)

        when:
        def filter = new PositiveFilter()

        then:
        for (int n : positives)
            filter.accept(n) == true

        for (int n : notPositives)
            filter.accept(n) == false
    }
}
