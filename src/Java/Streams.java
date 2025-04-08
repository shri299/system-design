package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        //sequential nature of streams
        List<Integer> salary = Arrays.asList(3,2,1,6,4,4);
        Stream<Integer> salaryStream = salary.stream();

        salaryStream.filter((Integer val) -> val>2)
                .peek((Integer val) -> System.out.println("filtering: "+val))
                .map((Integer val) -> val+10)
                .peek((Integer val) -> System.out.println("mapping: "+val))
                .sorted()
                .peek((Integer val) -> System.out.println("sorted: "+val))
                .collect(Collectors.toList());

        Integer[] age = {1,2,3,4};
        Stream<Integer> ageStream = Arrays.stream(age);

        //streams for primitive data type
        int[] age1 = {1,2,3,4};
        IntStream ageStream1 = Arrays.stream(age1);
    }
}
