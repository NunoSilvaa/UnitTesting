package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PositiveFilterTest {
    @Test
    void accept() {
        PositiveFilter filter = new PositiveFilter();
        List<Integer> positives = Arrays.asList(1, 2, 3, 70, 200, 4682);
        List<Integer> notPositives = Arrays.asList(0, -1, -2, -3, -70, -200, -4682);

        for (int n : positives)
            Assertions.assertTrue(filter.accept(n));

        for (int n : notPositives)
            Assertions.assertFalse(filter.accept(n));
    }
}
