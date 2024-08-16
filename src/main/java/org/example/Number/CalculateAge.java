package org.example.Number;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class CalculateAge {
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your birthdate(yyyy-mm-dd):");
        String birthdateString=scanner.nextLine();
        scanner.close();

        LocalDate birthdate=LocalDate.parse(birthdateString);
        LocalDate currentDate=LocalDate.now();
        Period age= Period.between(birthdate, currentDate);
        System.out.println("You are"+age.getYears()+"year old");


    }
}
