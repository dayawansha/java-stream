package stream;

import java.util.Arrays;
import java.util.List;

public class StreamIntNumersTotal {

    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);


    int sum2 = integers.stream()
            .mapToInt(e -> e)
            .sum();

    int sum3 = integers.stream()
            .mapToInt(Integer::intValue)
            .sum();

    int sum4 = integers.stream()
            .reduce(0, (a, b) -> a + b);


    int sum5 = integers.stream()
            .reduce(0, Integer::sum);



/*    Map<Integer, String> map = Map.of(
            1, "abc",
            2, "defg",
            3, "pqrst",
            4, "uvw",
            5, "xyz");

    int result = map.values().stream()
            .filter(string -> string.length() % 2 == 0)
            .mapToInt(String::length)
            .sum();*/


}
