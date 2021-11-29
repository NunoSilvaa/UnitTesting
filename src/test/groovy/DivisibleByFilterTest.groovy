import com.aor.numbers.DivisibleByFilter
import spock.lang.Specification

class DivisibleByFilterTest extends Specification{
    def 'acceptDivideBy2'(){
        given:
        def divisible = Arrays.asList(0, 2, 3, 4, 8, 100, 1000, 10000)
        def notDivisible = Arrays.asList(1, 3, 5, 13, 741, 10007)

        when:
        def filter = new DivisibleByFilter(2)

        then:
        for(int n : divisible)
            filter.accept(n) == true

        for(int n : notDivisible)
            filter.accept(n) == false
    }

    def 'acceptDivideBy3'(){
        given:
        def divisible = Arrays.asList(0, 3, 6, 9, 33, 999, 6666)
        def notDivisible = Arrays.asList(1, 2, 4, 5, 100, 1000, 10000)

        when:
        def filter = new DivisibleByFilter(3)

        then:
        for(int n : divisible)
            filter.accept(n) == true

        for(int n : notDivisible)
            filter.accept(n) == false
    }
}
