package bubbleSort;

import java.util.Arrays;
import java.util.List;

import org.example.bubbleSort.BubbleSort;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {

    private final BubbleSort<Integer> bubbleIntegerSort = new BubbleSort<>();
    private final BubbleSort<Double> bubbleDoubleSort = new BubbleSort<>();

    @Test
    public void sort_testWithInts() {
        List<Integer> numbers = Arrays.asList(1, 4, 5, 6, 8, 3, 8);
        List<Integer> result = Arrays.asList(1, 3, 4, 5, 6, 8, 8);
        assertEquals(result, bubbleIntegerSort.sort(numbers));
    }

    @Test
    public void sort_testWithDoubles() {
        List<Double> input = Arrays.asList(-9.3, 0.2, 4., 0.1, 5., 9.);
        List<Double> result = Arrays.asList(-9.3, 0.1, 0.2, 4., 5., 9.);
        assertEquals(result, bubbleDoubleSort.sort(input));
    }

    @Test
    public void sort_testWithEmptyList() {
        List<Integer> input = List.of();
        List<Integer> result = List.of();
        assertEquals(result, bubbleIntegerSort.sort(input));
    }

    @Test
    public void sort_testWithListContainsNull() {
        List<Double> input = Arrays.asList(null, 5.0001);
        List<Double> result = List.of(5.0001);
        assertEquals(result, bubbleDoubleSort.sort(input));
    }

    @Test
    public void sort_shouldThrowRuntimeException_whenInputIsNull() {
        List<Double> input = null;
        Class<RuntimeException> result = RuntimeException.class;
        assertThrows(result, () -> bubbleDoubleSort.sort(input));
    }
}
