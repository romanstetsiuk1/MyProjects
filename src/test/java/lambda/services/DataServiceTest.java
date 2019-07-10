package lambda.services;

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
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("Running thread r1");
            }
        };

        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("Running thread r2");
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }

}