package pearson;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FizzBuzz {

    private static final String SEPARATOR = " ";
    static BiPredicate<Integer, Integer> divByNumer = (dividend, divisor) -> dividend % divisor == 0;
    static BiPredicate<Integer, Integer> containsNum = (num, contained) ->
            Integer.toString(num).contains(Integer.toString(contained));

    private int lower;
    private int upper;
    private List<String> words;

    FizzBuzz(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    String execute() {
        words = fizzBuzz();
        return printWordFizzBuzz();
    }

    List<String> fizzBuzz() {
        return IntStream.rangeClosed(lower, upper)
                .mapToObj(i -> containsNum.test(i, 3) ? "lucky"
                        : divByNumer.test(i, 15) ? "fizzbuzz"
                        : divByNumer.test(i, 3) ? "fizz"
                        : divByNumer.test(i, 5) ? "buzz"
                        : Integer.toString(i))
                .collect(Collectors.toList());
    }

    private String printWordFizzBuzz() {
        return words.stream().collect(Collectors.joining(SEPARATOR));
    }

}
