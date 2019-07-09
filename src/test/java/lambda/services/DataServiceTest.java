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

}