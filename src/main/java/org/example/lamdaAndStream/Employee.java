package org.example.lamdaAndStream;

import java.util.Arrays;
import java.util.List;

public class Employee {

    String name;
    int age;
    String gender;
    String department;
    String organization;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Employee(String name, int age, String gender, String department, String organization) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.organization = organization;
    }


    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
        new Employee("Amit Singh", 34, "Male", "Finance", "Infosys"),
        new Employee("Deepa Patil", 29, "Female", "IT", "TCS"),
        new Employee("Rajesh Kumar", 42, "Male", "Finance", "Infosys"),
        new Employee("Lalitha Bhatt", 28, "Male", "IT", "TCS"),
        new Employee("Suresh Raina", 30, "Female", "IT", "TCS")
        );

        long maleInInfosys = employees.stream().filter(
                e -> "Male".equals(e.getGender()) && "Infosys".equals(e.getOrganization())).count();
        long femaleInInfosys = employees.stream().filter(
                e -> "Female".equals(e.getGender()) && "Infosys".equals(e.getOrganization())).count();
        long maleInTCS = employees.stream().filter(
                e -> "Male".equals(e.getGender()) && "TCS".equals(e.getOrganization())).count();
        long femaleInTCS = employees.stream().filter(
                e -> "Female".equals(e.getGender()) && "TCS".equals(e.getOrganization())).count();

        System.out.println("Male Employee in Infosys "+maleInInfosys);
        System.out.println("Female Employee in Infosys"+femaleInInfosys);
        System.out.println("Male Employee in TCS"+maleInTCS);
        System.out.println("Female Employee in TCS"+femaleInTCS);

        employees.stream().map(Employee::getDepartment).distinct().forEach( System.out::println);




    }
}