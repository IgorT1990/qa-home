package net.proselyte.streamapi;

import net.proselyte.streamapi.model.Specialist;
import net.proselyte.streamapi.model.Specialty;
import net.proselyte.streamapi.util.OldApproachUtil;
import net.proselyte.streamapi.util.StreamAPIUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class StreamAPIDemo {
    public static void main(String[] args) {

        // Old version
        List<Specialist> specialists = OldApproachUtil.getSpecialists();
        for (Specialist str : specialists)
            System.out.println(str);
        System.out.println("+++++++++++++++++++++++++");

        // New version Stream API
        System.out.println("================");
        List<Specialist> specialists1 = StreamAPIUtil.getSpecialists();
        StreamAPIUtil.printSpecialists(specialists1);

        // Old version
        System.out.println("================");
        System.out.println("Filter Old");
        List<Specialist> engineer = OldApproachUtil.filterBySpecialty(specialists, Specialty.ENGINEER);
        System.out.println(engineer);

        // New Version filtering by engineer
        System.out.println("======================");
        System.out.println("Filter stream API");
        StreamAPIUtil.printSpecialists(engineer);

        List<Specialist> devops = StreamAPIUtil.filterBySpecialty(specialists, Specialty.DEVOPS);
        StreamAPIUtil.printSpecialists(devops);


        // NEW version sorting by Name
        System.out.println("======================");
        System.out.println("Sorting by Name");
        List<Specialist> sortedSpecialistAsc = StreamAPIUtil.sortSpecialistsByNameAsc(specialists);
        StreamAPIUtil.printSpecialists(sortedSpecialistAsc);

        System.out.println("++++++++");

        List<Specialist> sortedSpecialistsDesc = StreamAPIUtil.sortSpecialistByNameDesc(specialists);
        StreamAPIUtil.printSpecialists(sortedSpecialistsDesc);

        //New version sorting by Salary
        System.out.println("====================");
        System.out.println("Sorting by Min Salary");
        Specialist withMinSalary = StreamAPIUtil.findWithMinSalary(specialists);
        System.out.println(withMinSalary);

        System.out.println("++++++++");

        System.out.println("Sorting by Max Salary");
        Specialist withMaxSalary = StreamAPIUtil.findWithMaxSalary(specialists);
        System.out.println(withMaxSalary);

        // New version grouping by specialty
        System.out.println("===================");
        System.out.println("Grouping");
        Map<Specialty, List<Specialist>> groupBySpecialty = StreamAPIUtil.groupBySpecialty(specialists);
        System.out.println(groupBySpecialty);

        // Check all engineers
        System.out.println("======================");
        System.out.println("All engineers");
        boolean allEngineers = StreamAPIUtil.matchAllEngineers(specialists);
        System.out.println(allEngineers);


        // Check any engineers
        System.out.println("========================");
        System.out.println("Any engineers");
        boolean anyEngineers = StreamAPIUtil.matchAnyEngineers(specialists);
        System.out.println(anyEngineers);

        // All salary more than ...
        System.out.println("================");
        System.out.println("all salary more then 10000");
        boolean allSalaryMore10000 = StreamAPIUtil.matchAllSalaryMoreThen(specialists, new BigDecimal(1000));
        System.out.println(allSalaryMore10000);

        // No one with salary more than
        System.out.println("==============");
        System.out.println("No one with salary bigger 1000");
        boolean noOneWithSalary1000 = StreamAPIUtil.matchNoneSalaryMoreThen(specialists, new BigDecimal(10000));
        System.out.println(noOneWithSalary1000);

    }
}
