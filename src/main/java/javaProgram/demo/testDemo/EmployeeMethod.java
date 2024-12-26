package javaProgram.demo.testDemo;

import java.util.*;
import java.util.stream.Collectors;


public class EmployeeMethod {

  public static  List<Employee> employees = Arrays.asList(
            new Employee(1, "meena", 24, "Female", "HR", "TCS", 23344L, "Pune"),
            new Employee(2, "adas", 25, "Male", "IT", "INFOSYS", 456456L, "Mumbai"),
            new Employee(3, "tina", 25, "Female", "HR", "TCS", 23344L, "HYDERABAD"),
            new Employee(4, "wewerrr", 24, "Male", "TECH", "INFOSYS", 5657L, "Mumbai"),
            new Employee(5, "nisha", 26, "Female", "HR", "TCS", 23344L, "Pune"),
            new Employee(6, "wrewr", 26, "Male", "IT", "INFOSYS", 23344L, "HYDERABAD"),
            new Employee(7, "neeti", 27, "Female", "HR", "TCS", 5657L, "Pune"),
            new Employee(8, "gjgjg", 27, "Male", "TECH", "INFOSYS", 456456L, "Pune"),
            new Employee(9, "miya", 28, "Female", "HR", "TCS", 23344L, "Mumbai"),
            new Employee(10, "qweqwerwq", 28, "Male", "IT", "INFOSYS", 456456L, "Pune")

    );


    public  void CountNumberOfEmployeeINEachDepartment() {
            long maleInInfosys = employees.stream().filter(
                    e -> "Male".equals(e.getGender()) && "Infosys".equals(e.getOrganization())).count();
            System.out.println("Male Employee in Infosys " + maleInInfosys);

            long femaleInInfosys = employees.stream().filter(
                    e -> "Female".equals(e.getGender()) && "Infosys".equals(e.getOrganization())).count();
            System.out.println("Female Employee in Infosys" + femaleInInfosys);

            long maleInTCS = employees.stream().filter(
                    e -> "Male".equals(e.getGender()) && "TCS".equals(e.getOrganization())).count();
            System.out.println("Male Employee in TCS" + maleInTCS);

            long femaleInTCS = employees.stream().filter(
                    e -> "Female".equals(e.getGender()) && "TCS".equals(e.getOrganization())).count();
            System.out.println("Female Employee in TCS" + femaleInTCS);
            employees.stream().map(Employee::getDepartment)
                    .distinct()
                    .forEach(System.out::println);
        }


        public  void EmployeeGroupByCity() {

            Map<String, List<Employee>> groupedByCity = employees
                    .stream()
                    .collect(Collectors.groupingBy(Employee::getCity));

            groupedByCity.forEach((city, emplist) ->
                    {
                        System.out.println("City:" + city);
                        emplist.forEach(System.out::println);
                    }
            );
        }

        public  void EmployeeGroupByAge() {
            Map<Integer, List<Employee>> groupByAge = employees
                    .stream()
                    .collect(Collectors.groupingBy(Employee::getAge));

            groupByAge.forEach((age, agelist) ->
            {
                System.out.println("Age:" + age);
                agelist.forEach(System.out::println);
            });

            employees.stream()
                    .filter(emp -> emp.getAge() > 28)
                    .forEach(System.out::println);
        }

        public  void maxAge(){

        Optional<Integer> maxAge = employees
                .stream()
                .map(Employee::getAge)
                .max(Integer::compare);
        maxAge.ifPresent(age -> System.out.println("Maximum Age:" + age));

    }


    public  void EmployeesMaleAverageAge() {
        Double maleAverage = employees.stream()
                .filter(Emp -> "M".equals((Emp.getGender())))
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0.0);
        System.out.println("Average age of the Male employee:"
                + maleAverage);
    }
    public  void EmployeesFeMaleAverageAge() {

        Double femaleAverage = employees.stream()
                .filter(Emp -> "F".equals(Emp.getGender()))
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0.0);


        System.out.println("Average age of the Female Employee:"
                + femaleAverage);

    }

   public  void  EmployeesDepartmentCout() {
        Map<String, Long> departmentCount =
                employees
                        .stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment, Collectors.counting()
                        ));

        departmentCount.forEach((deptName, count) ->
                System.out.println("Department:" + deptName + ",Number of Employee:" + count));
    }

public  void OldestEmpoyee() {
    Employee oldest =
            employees.stream()
                    .max(Comparator.comparing(Employee::getAge))
                    .orElse(null);

    if (oldest != null) {
        System.out.println("Oldest employee:" + oldest);
    } else {
        System.out.println("No employees found");
    }

}
public  void YoungestEmployee() {
    Employee youngest =
            employees
                    .stream()
                    .min(Comparator.comparing(Employee::getAge))
                    .orElse(null);

    if (youngest != null) {
        System.out.println("Youngest female Employee:" + youngest);
    } else {
        System.out.println("No female employees found");
    }

}


public static void Department() {

    Map<String, Long> departmentCount1 = employees.stream().
            collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    Optional<Map.Entry<String, Long>> maxDep = departmentCount1.entrySet().stream().max(Map.Entry.comparingByValue());


    if (maxDep.isPresent()) {
        System.out.println("Department with the most employees:" + maxDep.get().getKey()
                + "(" + maxDep.get().getValue() + "employees)");
    } else {
        System.out.println("No department fount:");
    }


    Map<String, Double> averageSalary = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    averageSalary.forEach((dept, avgSalary) ->
            System.out.println("Department:" + dept + ",Average Salary:" + avgSalary));


    boolean hasHREmployees = employees.stream().anyMatch(e -> "HR".equals(e.getDepartment()));
    System.out.println("Are there any HR department employee?" + (hasHREmployees ? "Yes" : "No"));


    long totalSalary = employees.stream().mapToLong(Employee::getSalary).sum();
    double averageSalary1 = employees.stream().mapToLong(Employee::getSalary).average().orElse(0);


    long highestsalary = employees.stream().mapToLong(Employee::getSalary).max().orElse(0);
    System.out.println("The highest salary in the organization is:" + highestsalary);
    System.out.println("Total salary:" + totalSalary);
    System.out.println("Average salary:" + averageSalary1);


    long secondHighestSalary = employees.stream()
            .mapToLong(Employee::getSalary)
            .boxed()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst()
            .orElse(0L);
    System.out.println("The second Highest salary in the organization is:" + secondHighestSalary);

}



    }



