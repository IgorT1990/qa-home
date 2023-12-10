package homework.hellocucumber.src.test.java.hellocucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class StepsDefsStudents {
    private List<Map<String, String>> students;

    @Given("the following students exist")
    public void theFollowingStudentsExist(DataTable dataTable) {
        this.students = dataTable.asMaps(String.class, String.class);
    }

    @When("students are sorted by age")
    public void theStudentsAreSortedByAge() {
        Collections.sort(students, Comparator.comparingInt(s -> Integer.parseInt(s.get("age"))));
    }

    @Then("the youngest student is at least 16 years")
    public void theYoungestStudentIsAtLeast16YearsOld() {
        int youngestAge = Integer.MAX_VALUE;
        for (Map<String, String> student : students) {
            int age = Integer.parseInt(student.get("age"));
            if (age < youngestAge) {
                youngestAge = age;
            }
        }
        Assertions.assertTrue(youngestAge >= 16, "The youngest student is not at least 16 years old");
    }
}

