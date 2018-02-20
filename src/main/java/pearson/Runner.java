package pearson;

public class Runner {

    public static void main(String[] args) {

        if (args.length != 2) {
            throw new IllegalArgumentException(
                    "missing params: startRange endRange, example: java -jar fizzbuzz-1.0-SNAPSHOT-jar-with-dependencies.jar 1 20");
        }

        try {
            if (Integer.parseInt(args[0]) <= 0 || Integer.parseInt(args[0]) > Integer.parseInt(args[1])) {
                throw new IllegalArgumentException("startRange should be smaller than endRange and starting from 1");
            }
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("startRange and endRange should be valid numbers");
        }

        final FizzBuzz fizzBuzz = new FizzBuzz(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

        System.out.println(fizzBuzz.execute());
    }

}
