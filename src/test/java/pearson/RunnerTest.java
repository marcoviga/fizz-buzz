package pearson;

import org.junit.Test;

import static org.junit.Assert.*;

public class RunnerTest {

    @Test(expected = IllegalArgumentException.class)
    public void test_negative_args() {
        Runner.main(new String[]{"-1", "2"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_zero_in_args() {
        Runner.main(new String[]{"0", "2"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_switched_order_args() {
        Runner.main(new String[]{"2", "0"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_wrong_format_args() {
        Runner.main(new String[]{"word", "1"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_zero_args() {
        Runner.main(new String[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_more_than_two_args() {
        Runner.main(new String[]{"1", "2", "3"});
    }

    @Test
    public void test_positive_boundary() {
        try {
            Runner.main(new String[]{"1", "2"});
        } catch (IllegalArgumentException e) {
            fail();
        }
    }
}
