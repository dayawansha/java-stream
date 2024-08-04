package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest2Map {
    public static void main (String arg[]) {


        /// your example one
        // ArrayList<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4,4,5,5,6,7,7));
        List<Integer> integerList = Arrays.asList(1, 2, 2, 3, 4,4,5,5,6,7,7);
        HashSet<Integer> namesSet = new HashSet<>(integerList);
        int total = 0;
        for (int num : namesSet) {
            if ( num >5)
            {
                total  = total + num;
            }
        }
        System.out.println("total="+total);

        Integer total2 = namesSet.stream()
                .map( i -> i> 5 ? i : 0)
                .reduce(0, (a, b) -> a + b);
        System.out.println("total2="+total2);

        Integer total3 = namesSet.stream()
                .map( i -> i> 5 ? i :0)
                .reduce(0, Integer::sum);

        System.out.println("total3="+total3);

        //your example two
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }
}
