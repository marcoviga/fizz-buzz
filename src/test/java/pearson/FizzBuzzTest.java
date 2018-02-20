package pearson;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FizzBuzzTest {

    @Test
    public void test_divByNumber_success() {
        assertTrue(FizzBuzz.divByNumer.test(3, 3));
    }

    @Test
    public void test_divByNumber_fail(){
        assertFalse(FizzBuzz.divByNumer.test(1, 3));
    }

    @Test
    public void test_execute_1to20() {
        FizzBuzz fizzBuzz = new FizzBuzz(1, 20);
        final String expected = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";
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
        final List<String> expected = Arrays.asList("1", "2", "fizz");
        final List<String> actual = fizzBuzz.fizzBuzz();
        assertEquals(expected, actual);
    }

    @Test
    public void test_execute_fizzBuzz_fizz() {
        FizzBuzz fizzBuzz = new FizzBuzz(3, 3);
        final List<String> expected = Arrays.asList( "fizz");
        final List<String> actual = fizzBuzz.fizzBuzz();
        assertEquals(expected, actual);
    }

    @Test
    public void test_execute_fizzBuzz_fizzbuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz(15, 15);
        final List<String> expected = Arrays.asList( "fizzbuzz");
        final List<String> actual = fizzBuzz.fizzBuzz();
        assertEquals(expected, actual);
    }

    @Test
    public void test_execute_fizzBuzz_buzz() {
        FizzBuzz fizzBuzz = new FizzBuzz(5, 5);
        final List<String> expected = Arrays.asList( "buzz");
        final List<String> actual = fizzBuzz.fizzBuzz();
        assertEquals(expected, actual);
    }


}
