package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);

    @Test
    public void deduplicate() {
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
    }
}
