package net.proselyte.streamapi.util;

import net.proselyte.streamapi.model.Specialist;
import net.proselyte.streamapi.model.Specialty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OldApproachUtil {

    // Create current list of specialist
    public static List<Specialist> getSpecialists(){
        List<Specialist> result = new ArrayList<>();
        result.add(new Specialist("Ivan Ivanenko", new BigDecimal(5000), Specialty.ENGINEER));
        result.add(new Specialist("Olexander Panenko", new BigDecimal(4000), Specialty.ENGINEER));
        result.add(new Specialist("Serhii Serhiienko", new BigDecimal(3000), Specialty.DEVOPS));
        result.add(new Specialist("Fedir Fedorenko", new BigDecimal(2000), Specialty.DEVOPS));
        result.add(new Specialist("Kyrylo Kyrylenko", new BigDecimal(10000), Specialty.MANAGER));
        result.add(new Specialist("Petro Petrenko", new BigDecimal(10000), Specialty.MANAGER));

        return result;
    }

    // Searching by specialty
    public static List<Specialist> filterBySpecialty(List<Specialist> specialists, Specialty specialty){
        List<Specialist> result = new ArrayList<>();
        for (int i = 0; i < specialists.size(); i++){
            if (specialists.get(i).getSpecialty().equals(specialty)){
                result.add(specialists.get(i));
            }
        }
        return result;
    }

    // Sorting name by asc / desc



}
