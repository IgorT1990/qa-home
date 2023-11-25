package net.proselyte.streamapi.util;

import net.proselyte.streamapi.model.Specialist;
import net.proselyte.streamapi.model.Specialty;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPIUtil {
    // Add specialists to the List
    public static List<Specialist> getSpecialists() {
        return List.of(
                new Specialist("Ivan Ivanenko", new BigDecimal(5000), Specialty.ENGINEER),
                new Specialist("Olexander Panenko", new BigDecimal(4000), Specialty.ENGINEER),
                new Specialist("Serhii Serhiienko", new BigDecimal(3000), Specialty.DEVOPS),
                new Specialist("Fedir Fedorenko", new BigDecimal(2000), Specialty.DEVOPS),
                new Specialist("Kyrylo Kyrylenko", new BigDecimal(10000), Specialty.MANAGER),
                new Specialist("Petro Petrenko", new BigDecimal(10000), Specialty.MANAGER)
        );
    }

    // Print specialists to the console
    public static void printSpecialists(List<Specialist> specialists) {
        specialists.forEach(System.out::println);
    }

    // Search by the specialty

    public static List<Specialist> filterBySpecialty(List<Specialist> specialists, Specialty specialty) {
        return specialists.stream()
                .filter(specialist -> specialist.getSpecialty().equals(specialty))
                .collect(Collectors.toList());
    }

    // Sorting by asc / desc

    public static List<Specialist> sortSpecialistsByNameAsc(List<Specialist> specialists) {
        return specialists.stream()
                .sorted(Comparator.comparing(Specialist::getName))
                .collect(Collectors.toList());
    }

    public static List<Specialist> sortSpecialistByNameDesc(List<Specialist> specialists) {
        return specialists.stream()
                .sorted(Comparator.comparing(Specialist::getName).reversed())
                .collect(Collectors.toList());

    }

    // Min / Max salary

    public static Specialist findWithMinSalary(List<Specialist> specialists) {
        return specialists.stream()
                .min(Comparator.comparing(Specialist::getSalary))
                .orElse(null);
    }

    public static Specialist findWithMaxSalary(List<Specialist> specialists){
        return specialists.stream()
                .max(Comparator.comparing(Specialist::getSalary))
                .orElse(null);
    }

    // Grouping by the specialty

    public static Map<Specialty, List<Specialist>> groupBySpecialty (List<Specialist> specialists){
        return specialists.stream()
                .collect(Collectors.groupingBy(Specialist::getSpecialty));

    }

    // Checking that all engineers are in

    public static boolean matchAllEngineers(List<Specialist> specialists){
        return specialists.stream()
                .allMatch(specialist -> specialist.getSpecialty().equals(Specialty.ENGINEER));
    }

    // Checking that concretion engineers are in

    public static boolean matchAnyEngineers (List<Specialist> specialists){
        return specialists.stream()
                .anyMatch(specialist -> specialist.getSpecialty().equals(Specialty.ENGINEER));
    }

    // Check that salary more than ...

    public static boolean matchAllSalaryMoreThen(List<Specialist> specialists, BigDecimal salary){
        return specialists.stream()
                .allMatch(specialist -> specialist.getSalary().compareTo(salary) > 0);
    }

    // Check that nobody has bigger salary then ...

    public static boolean matchNoneSalaryMoreThen(List<Specialist> specialists, BigDecimal salary){
        return specialists.stream()
                .noneMatch(specialist -> specialist.getSalary().compareTo(salary) > 0);
    }

}
