package org.example.bubbleSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BubbleSort<T extends Comparable<T>> {

    public List<T> sort(List<T> input) {
        if (input == null) {
            throw new RuntimeException("Input is null");
        }
        List<T> inputWithoutNull = new ArrayList<>(input.stream().filter(Objects::nonNull).toList());
        return bubbleSort(inputWithoutNull);
    }

    private List<T> bubbleSort(List<T> input) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < input.size() - 1; i++) {
                if (input.get(i).compareTo(input.get(i + 1)) > 0) {
                    T temp = input.get(i);
                    input.set(i, input.get(i + 1));
                    input.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        return input;
    }
}
