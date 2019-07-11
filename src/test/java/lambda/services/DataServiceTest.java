package lambda.services;

import lambda.interfaces.MultiArgInterface;
import lambda.interfaces.MyFunctionalInterface;
import lambda.objects.Person;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class DataServiceTest {

    @Test
    public void getPeopleTest() throws IOException {
        List<Person> people = DataService.getPeople();
        Assertions.assertThat(people).hasSize(1000);
    }

    @Test
    public void threadsLambdas() {
//        Runnable r1 = new Runnable() {
//            public void run() {
//                System.out.println("Running thread r1");
//            }
//        };
//
//        Runnable r2 = new Runnable() {
//            public void run() {
//                System.out.println("Running thread r2");
//            }
//        };
//
//        new Thread(r1).start();
//        new Thread(r2).start();


//        functional interface
        Runnable r1 = () -> System.out.println("Running thread r1");
        Runnable r2 = () -> System.out.println("Running thread r1");

        new Thread(r1).start();
        new Thread(r2).start();

    }

    @Test
    public void multiCommand() {
        Runnable r1 = () -> {
            System.out.println("Line 1");
            System.out.println("Line 2");
        };
        new Thread(r1).start();
    }

    @Test
    public void myFunctionalInterfaceTest() {
        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("Message from myFunctionalInterface");
        myFunctionalInterface.printMessage();
    }

    @Test
    public void multiArgInterfaceTest() {
        MultiArgInterface multiArgInterface = (x, y) -> {
            int sum = x + y;
            System.out.println("Sum = " + sum);
        };
        multiArgInterface.sum(50, 25);
    }

    //collections
    @Test
    public void collectionsLambda() throws IOException {
        List<Person> people = DataService.getPeople();

//        sort
//        Collections.sort(people, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getLastName().compareToIgnoreCase(o2.getLastName());
//            }
//        });
//
//        for (Person person : people) {
//            System.out.println(person.getLastName());
//        }

        Comparator<Person> comparator = (o1, o2) -> o1.getLastName().compareToIgnoreCase(o2.getLastName());
        people.sort(comparator);
        people.forEach(person -> System.out.println(person.getLastName()));
    }

}