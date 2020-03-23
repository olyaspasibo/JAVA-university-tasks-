package part_3_var4;

import java.util.Scanner;

public class Employee {

    public String surname;
    public String position;
    public Double salary;
    public Integer birthday;

    public Employee(){
//        Scanner in = new Scanner(System.in);
//        System.out.print("Input surname: ");
//        String surname = in.next();
//        System.out.print("Input position: ");
//        String position = in.next();
//        System.out.print("Input salary: ");
//        Double salary = in.nextDouble();
//        System.out.print("Input birthday(year): ");
//        Integer birthday = in.nextInt();
//        this.surname = surname;
//        this.position = position;
//        this.salary = salary;
//        this.birthday = birthday;

    }

     Employee(String surname, String position, Double salary, Integer birthday){
        this.surname = surname;
        this.position = position;
        this.salary = salary;
        this.birthday = birthday;

    }

    public void print(){
        System.out.println(this.surname + " " + this.position + " " + this.salary + " " + this.birthday);
    }




}
