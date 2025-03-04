package stream;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Model class
class Person
{
    public Person(Integer id, String fname, String lname) {
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }

    private Integer id;
    private String fname;
    private String lname;

    //Getters and Setters

    @Override
    public String toString() {
        return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}

public class StreamUniqueObject {

        public static void main(String[] args) {

            Person lokesh = new Person(1, "Lokesh", "Gupta");
            Person brian = new Person(2, "Brian", "Clooney");
            Person kkk = new Person(2, "Brian", "Clooney");
            Person alex = new Person(3, "Alex", "Kolen");
            Person lll = new Person(3, "Alex", "Kolen");

            //Add some random persons
            Collection<Person> list = Arrays.asList(lokesh,brian,alex,lll,kkk);

            // Get distinct objects by key
            List<Person> distinctElements = list.stream()
                    .filter(distinctByKey(p -> p.getId()) )
                    .collect( Collectors.toList() );


            // Let's verify distinct elements
//            System.out.println( distinctElements );

            HashSet<Object> seen=new HashSet<>();
//            employee.removeIf(e->!seen.add(e.getID()));
        }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
