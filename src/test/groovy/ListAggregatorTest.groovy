import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListAggregator
import spock.lang.Specification

class ListAggregatorTest extends Specification{
    private def list

    def setup(){
        list = Arrays.asList(1, 2, 4, 2, 5)
    }

    def 'max_bug_7263'(){
        given:
        def list404 = [-1, -4, -5]

        when:
        ListAggregator aggregator = new ListAggregator()
        int max = aggregator.max(list404)

        then:
        max == -1
    }
    def 'distinct_bug_8726'(){
        given:
        GenericListDeduplicator deduplicator = Mock(GenericListDeduplicator.class)
        def aggregator = new ListAggregator()
        deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4)

        when:
        def distinct = aggregator.distinct(list, deduplicator)

        then:
        distinct == 3
    }

    def 'distinct'(){
        given:
        GenericListDeduplicator deduplicator = Mock(GenericListDeduplicator.class)
        def aggregator = new ListAggregator()
        deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4, 5)

        when:
        def distinct = aggregator.distinct(list, deduplicator)

        then:
        distinct == 4
    }

    def 'sum'(){
        when:
        ListAggregator aggregator = new ListAggregator()
        int sum = aggregator.sum(list)

        then:
        sum == 14
    }

    def 'max'(){
        when:
        ListAggregator aggregator = new ListAggregator()
        int max = aggregator.max(list)

        then:
        max == 5
    }

    def 'min'(){
        when:
        ListAggregator aggregator = new ListAggregator()
        int min = aggregator.min(list)

        then:
        min == 1
    }
}
