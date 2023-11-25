package homework.stream_api;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

public class Employees_Main {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/itaranukha/IdeaProjects/Hillel/qa-home/src/test/java/homework/stream_api/employees_small.csv");
        List<String> employeesList = FileUtils.readLines(file, Charset.defaultCharset());

        List<Employees> employees = employeesList.stream()
                .skip(1)
                .map(line ->{
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0]);
                    String firstName = parts[1];
                    String lastName = parts[2];
                    Manager manager = Manager.valueOf(parts[3]);
                    double salary = Double.parseDouble(parts[4]);
                    return new Employees(id, firstName, lastName, manager, salary);
                })
                .sorted((e1,e2) -> {
            int compareByLastName = e1.getLastName().compareTo(e2.getLastName());
            if (compareByLastName == 0){
                return e1.getFirstName().compareTo(e2.getFirstName());
            }
            return compareByLastName;
        })
                .filter(employees1 -> employees1.getManager() == Manager.N)
                .collect(Collectors.toList());

        employees.forEach(System.out::println);
    }
    }

