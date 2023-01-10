package balancedWordCounter;

import org.example.balancedWordCouter.BalancedWordsCounter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BalancedWordCounterTest {

    private final BalancedWordsCounter balancedWordsCounter = new BalancedWordsCounter();

    @Test
    public void testWithCorrectString() {
        String input = "aabbabcccba";
        Integer result = 28;
        assertEquals(result, balancedWordsCounter.count(input));
    }

    @Test
    public void testWithEmptyInput_shouldReturn0() {
        String input = "";
        Integer result = 0;
        assertEquals(result, balancedWordsCounter.count(input));
    }

    @Test
    public void testWithInputWithNotLetterCharacter_shouldThrowException() {
        String input = "abababa1";
        Class<RuntimeException> result = RuntimeException.class;
        assertThrows(result, () -> balancedWordsCounter.count(input));
    }

    @Test
    public void testWithInputNull_shouldThrowException() {
        String input = null;
        Class<RuntimeException> result = RuntimeException.class;
        assertThrows(result, () -> balancedWordsCounter.count(input));
    }
}
