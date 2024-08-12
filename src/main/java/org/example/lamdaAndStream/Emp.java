package org.example.lamdaAndStream;

import java.util.*;
import java.util.stream.Collectors;

public class Emp {
    private int id;
    private String name;
    private int age;
    private long salary;
    private String gender;
    private String deptName;
    private String city;


    public Emp(int id, String name, int age, long salary, String gender, String deptName, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.deptName = deptName;
        this.city = city;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getCity()
    {
        return city;
    }
    public String toString()
    {
        return String.format("%d %s %d %s %s %s",id, name, age, salary, gender, deptName, city);

    }

public static void main(String args[])
{
        List<Emp> employees= Arrays.asList(
                new Emp(1,"Aditi",30,10000,"F","HR","Mumbai"),
                new Emp(1,"Rahul",30,11000,"M","Tech","Banglore"),
                new Emp(1,"Vishal",30,12000,"M","Tech","Mumbai"),
                new Emp(1,"Lakshmi",30,14000,"F","HR","Banglore")
                );


    Map<String, List<Emp>> groupedByCity=
            employees.stream().collect(Collectors.groupingBy(Emp::getCity));

    Map<Integer, List<Emp>> groupByAge= employees.stream().collect(Collectors.groupingBy(Emp::getAge));

    groupedByCity.forEach((city,emplist)->{ System.out.println("City:"+city);
        emplist.forEach(System.out::println);
    });

    groupByAge.forEach((age,agelist)->{ System.out.println("Age:"+age);
        agelist.forEach(System.out::println);
    });

     employees.stream().filter(emp->emp.age>28).forEach(System.out::println);


    Optional<Integer> maxAge=employees.stream().map(Emp::getAge).max(Integer::compare);
    maxAge.ifPresent(age->System.out.println("Maximum Age:"+age));


    Double maleAverage=employees.stream().filter(Emp->"M".equals((Emp.getGender())))
            .mapToInt(Emp::getAge).average().orElse(0.0);

    Double femaleAverage=employees.stream().filter(Emp->"F".equals(Emp.getGender()))
            .mapToInt(Emp::getAge).average().orElse(0.0);

    System.out.println("Average age of the Male employee:"+maleAverage);
    System.out.println("Average age of the Female Employee:"+femaleAverage);


    Map<String,Long>departmentCount=employees.stream().collect(Collectors.groupingBy(
            Emp::getDeptName,Collectors.counting()
    ));

    departmentCount.forEach((deptName,count)->
            System.out.println("Department:"+deptName+",Number of Employee:"+count));

    Emp oldest=employees.stream().max(Comparator.comparing(Emp::getAge)).orElse(null);
    if(oldest!=null){System.out.println("Oldest employee:"+oldest); }
    else { System.out.println("No employees found");}


    Emp youngest=employees.stream().min(Comparator.comparing(Emp::getAge)).orElse(null);
    if(youngest!=null) {
        System.out.println("Youngest female Employee:" + youngest);
    }
    else { System.out.println("No female employees found"); }

    Map<String, Long> departmentCount1=employees.stream().
            collect(Collectors.groupingBy(Emp::getDeptName,Collectors.counting()));
    Optional<Map.Entry<String,Long>> maxDep=departmentCount1.entrySet().stream().max(Map.Entry.comparingByValue());

    if(maxDep.isPresent()) {
        System.out.println("Department with the most employees:" + maxDep.get().getKey()
                + "(" + maxDep.get().getValue() + "employees)");
    }
    else{  System.out.println("No department fount:"); }


    Map<String, Double> averageSalary=employees.stream()
            .collect(Collectors.groupingBy(Emp::getDeptName,Collectors.averagingDouble(Emp::getSalary)));
    averageSalary.forEach((dept,avgSalary)->System.out.println("Department:"+dept+",Average Salary:"+avgSalary));



    boolean hasHREmployees=employees.stream().anyMatch(e->"HR".equals(e.getDeptName()));
    System.out.println("Are there any HR department employee?"+(hasHREmployees?"Yes":"No"));


   long totalSalary=employees.stream().mapToLong(Emp::getSalary).sum();
   double averageSalary1=employees.stream().mapToLong(Emp::getSalary).average().orElse(0);


   long highestsalary=employees.stream().mapToLong(Emp::getSalary).max().orElse(0);

   System.out.println("The highest salary in the organization is:"+highestsalary);

     System.out.println("Total salary:"+totalSalary);
    System.out.println("Average salary:"+averageSalary1);


    long secondHighestSalary=employees.stream()
            .mapToLong(Emp::getSalary)
            .boxed()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst()
            .orElse(0L);

    System.out.println("The second Highest salary in the organization is:"+secondHighestSalary);



}

    }

