package pearson;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FizzBuzzTest {

    @Test
    public void test_divByNumber_success() {
        assertTrue(FizzBuzz.divByNumer.test(3, 3));
    }

    @Test
    public void test_divByNumber_fail() {
        assertFalse(FizzBuzz.divByNumer.test(1, 3));
    }

    @Test
    public void test_containsNum_success() {
        assertTrue(FizzBuzz.containsNum.test(1303, 3));
    }

    @Test
    public void test_execute_1to20() {
        FizzBuzz fizzBuzz = new FizzBuzz(1, 20);
        final String expected = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz\n" +
                "lucky: 2\n" +
                "integer: 10\n" +
                "fizzbuzz: 1\n" +
                "fizz: 4\n" +
                "buzz: 3\n";
        final String res = fizzBuzz.execute();
        assertEquals(expected, res);
    }

    @Test
    public void test_execute_fizzBuzz_range_dim_one() {
        FizzBuzz fizzBuzz = new FizzBuzz(1, 1);
        final String expected = "1";
        final List<String> actual = fizzBuzz.fizzBuzz();
        assertEquals(1, actual.size());
        assertEquals(expected, actual.get(0));
    }

    @Test
    public void test_execute_fizzBuzz_range_dim_three() {
        FizzBuzz fizzBuzz = new FizzBuzz(1, 3);
        final List<String> expected = Arrays.asList("1", "2", "lucky");
        final List<String> actual = fizzBuzz.fizzBuzz();
        assertEquals(expected, actual);
    }

    @Test
    public void test_execute_fizzBuzz_lucky() {
        FizzBuzz fizzBuzz = new FizzBuzz(3, 3);
        final List<String> expected = Arrays.asList("lucky");
        final List<String> actual = fizzBuzz.fizzBuzz();
        assertEquals(expected, actual);
    }

    @Test
    public void test_execute_fizzBuzz_fizzbuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz(15, 15);
        final List<String> expected = Arrays.asList("fizzbuzz");
        final List<String> actual = fizzBuzz.fizzBuzz();
        assertEquals(expected, actual);
    }

    @Test
    public void test_execute_fizzBuzz_buzz() {
        FizzBuzz fizzBuzz = new FizzBuzz(5, 5);
        final List<String> expected = Arrays.asList("buzz");
        final List<String> actual = fizzBuzz.fizzBuzz();
        assertEquals(expected, actual);
    }

    @Test
    public void test_wordCounts() {
        FizzBuzz fizzBuzz = new FizzBuzz(1, 4);
        fizzBuzz.execute();

        final Map<String, Integer> actual = fizzBuzz.wordCounts();
        assertEquals(2, actual.size());

        Map<String, Integer> expected = new HashMap<>();
        expected.put("integer", 3);
        expected.put("lucky", 1);

        assertEquals(expected, actual);
    }
}
