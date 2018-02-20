package pearson;

import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FizzBuzz {

    private static final String SEPARATOR = " ";
    private static final String REGEX_NUMBER = "-?\\d+";

    static BiPredicate<Integer, Integer> divByNumer = (dividend, divisor) -> dividend % divisor == 0;
    static BiPredicate<Integer, Integer> containsNum = (num, contained) ->
            Integer.toString(num).contains(Integer.toString(contained));
    static Predicate<String> isInteger = w -> w.matches(REGEX_NUMBER);

    private int lower;
    private int upper;
    private List<String> words;
    private Map<String, Integer> wordCounter;

    FizzBuzz(final int lower, final int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    String execute() {
        words = fizzBuzz();
        wordCounter = wordCounts();
        return printWordFizzBuzz() + System.lineSeparator() + printWordCounts();
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

    Map<String, Integer> wordCounts() {
        return words.stream()
                .collect(Collectors.toMap(w -> isInteger.test(w) ? "integer" : w,
                        w -> 1,
                        Integer::sum));
    }

    private String printWordFizzBuzz() {
        return words.stream().collect(Collectors.joining(SEPARATOR));
    }

    private String printWordCounts() {
        StringBuilder stringBuilder = new StringBuilder();
        wordCounter.forEach((k, v) -> stringBuilder.append(k).append(": ").append(v).append("\n"));
        return stringBuilder.toString();
    }
}
