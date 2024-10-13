package org.example.testDemo;

public class EmployeeTest {
    public static void main(String[] args)
    {
        EmployeeMethod e=new EmployeeMethod();
        System.out.println("*********Test Employee***************");
        e.CountNumberOfEmployeeINEachDepartment();
        e.EmployeeGroupByCity();
        e.EmployeeGroupByAge();
        e.maxAge();
        e.EmployeesMaleAverageAge();
       e.EmployeesFeMaleAverageAge();
       e.EmployeesDepartmentCout();
       e.OldestEmpoyee();
       e.YoungestEmployee();
       e.Department();
    }
}
