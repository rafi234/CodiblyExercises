package org.example.balancedWordCouter;

import java.util.*;

public class BalancedWordsCounter {

    public Integer count(String input) {
        if (input == null) {
            throw new RuntimeException("Input is null!");
        }
        if (input.equals("")) {
            return 0;
        }
        if (!isWordOnlyWithLetters(input)) {
            throw new RuntimeException("Input is incorrect, should contain only letters.");
        }
        int count = input.length() * 2 - 1;
        for (int i = 3; i <= input.length(); ++i) {
            for (int j = 0; j <= input.length() - i; ++j) {
                String str = input.substring(j, i + j);
                count = isWordBalanced(str) ? count + 1 : count;
            }
        }
        System.out.println(count);
        return count;
    }

    private boolean isWordBalanced(String word) {
        Map<String, Integer> characterMap = new HashMap<>();
        Arrays.stream(word.split("")).forEach(strPart -> {
            characterMap.put(strPart, characterMap.getOrDefault(strPart, 0) + 1);

        });
        int valuesSetSize = new HashSet<>(characterMap.values()).size();
        return valuesSetSize == 1;
    }

    private boolean isWordOnlyWithLetters(String str) {
        return Arrays.stream(str.split(""))
                .allMatch(s -> s.matches("[a-zA-Z]"));
    }
}
