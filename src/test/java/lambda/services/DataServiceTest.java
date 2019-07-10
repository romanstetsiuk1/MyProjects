package lambda.services;

import lambda.interfaces.MyFunctionalInterface;
import lambda.objects.Person;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
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
}