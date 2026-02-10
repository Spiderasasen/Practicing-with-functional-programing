import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.List;

public class Main {

    public static void print_answer(Object answer){
        System.out.println("Answer: " + answer);
    }

    public static void main(String[] args) {
        // Create and test a solution to solve the following problems using
        // functional programming:
        Collection<String> strs = Arrays.asList("elon", "mascot", "phoenix", "clemson", "has", "tiger", "niner", "eagle");
        Collection<Integer> ints = Arrays.asList(13, 17, 7, 2, 4, 15, 32, 90);


        // PROBLEM 1: Given a collection of Strings, create and print a list of strings, but omitting
        // any that contain an "o") given the inputs below, the result should be
        // a list with ["has", "tiger", "niner", "eagle"]
        List<String> answer1 = strs.stream()
                .filter(str -> !str.contains("o"))
                .toList();
        print_answer(answer1);

        // PROBLEM 2: Given a collection of Strings, create and print a List of Strings, first
        // appending an "x" to the end of each word, then remove any that contain the substring "nx"
        List<String> answer2 = strs.stream()
                .map(str -> str.concat("x"))
                .filter(str -> !str.endsWith("nx"))
                .toList();
        print_answer(answer2);

        // PROBLEM 3: Given a collection of Integers, create and print a list with all numbers
        // between 12 and 19 omitted
        List<Integer> answer3 = ints.stream()
                .filter(x -> x > 12 && x < 19)
                .toList();
        print_answer(answer3);


        // PROBLEM 4: Given a collection of Integers, omitting any with two or more digits,
        // sum the squares of all numbers and add the product to 42. (In the ints list given,
        // the correct answer should be 42+25+49+4+16 = 111
        Integer answer4 = ints.stream()
                .filter(x -> x < 10)
                .map(x -> x*x)
                .reduce(0, (x,y) -> x+y) + 42;
        print_answer(answer4);


        // PROBLEM 5: Given a collection of Strings, create and print a List of Strings
        // by first removing any with lengths between 4 and 6 (inclusive), then by adding
        // a "z" after the first letter of each remaining word.
        List<String> answer5 = strs.stream()
                .filter(str -> str.length() < 4 || str.length() > 6)
                .map(str -> str.substring(0,1) + "z" + str.substring(1))
                .toList();
        print_answer(answer5);


        // PROBLEM 6: Given a collection of Integers, return a list of the numbers
        // multiplied by 7, omitting any that end in 1
        List<Integer> answer6 = ints.stream()
                .map(x -> x * 7)
                .filter(x -> !x.toString().endsWith("1"))
                .toList();
        print_answer(answer6);


        // PROBLEM 7: Given a collection of Integers, excluding any numbers
        // ending in 7, return the result of
        // adding together each of the remaining numbers plus an extra 2 every
        // time values are added.
        // EX: If we had a list with the following remaining
        // values (after 7s are removed): [5, 2, 4, 15, 90]. The math would result in:
        // (0  + 5 + 2) // Starting at 0, add the first element (5) and 2 extra
        // (7  + 2 + 2)  // Given the 7 from the last step, add 2 plus 2 extra
        // (11 + 4 + 2) // GIven 11 from the prior sum, add 4 plus 2 extra
        // (17 + 15 + 2)// Given 17 from the prior sum, add 15 plus 2 extra
        // (34 + 90 + 2)// Finally, add 90 plus 2 to the running sum to get the result of 126
        // HINT: This is relatively easy to do - requiring only 2 methods after .stream()
        Integer answer7 = ints.stream()
                .filter(x -> !x.toString().endsWith("7"))
                .reduce(0, (y, x) -> y + x + 2);
        print_answer(answer7);

    }

}
