package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class StreamAdvance {
    public static void main (String arg[]) {

        List<String> l = new ArrayList(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream();
        l.add("three");
        String st = sl.collect(joining(" "));
        System.out.println("string: " + st);


        //this is still considered an incorrect usage of Streams.
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        map.keySet().parallelStream().forEach(key -> {
            if (key == 3) {
                map.put(3,0);
            }
        });
        System.out.println("map: " + map);


        try {
            List<String> listOfStrings =
                    new ArrayList<>(Arrays.asList("one", "two"));

            // This will fail as the peek operation will attempt to add the
            // string "three" to the source after the terminal operation has
            // commenced.
            String concatenatedString = listOfStrings
                    .stream()

                    // Don't do this! Interference occurs here.
                    .peek(s -> listOfStrings.add("three"))

                    .reduce((a, b) -> a + " " + b)
                    .get();
            System.out.println("Concatenated string: " + concatenatedString);

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.toString());
        }
    }
}
