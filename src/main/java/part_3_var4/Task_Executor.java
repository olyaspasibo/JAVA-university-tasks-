package part_3_var4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Task_Executor {

    public ArrayList<Employee> employees;

    public Task_Executor(ArrayList<Employee> employees){
        this.employees = employees;
    }


    public static ArrayList<Employee> readFromCsv() {
        String csvFile = "/Users/olgaspasibo/Downloads/JAVA-university-tasks--master/src/main/java/part_3_var4/employees.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = " ";
        ArrayList<Employee> listEmp = new ArrayList<Employee>();
        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                String[] inf = line.split(cvsSplitBy);

                Employee newEmp = new Employee(inf[0], inf[1], Double.parseDouble(inf[2]), Integer.parseInt(inf[3]));

                listEmp.add(newEmp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return listEmp;

    }

    public void upSalary15per(){
        for(Employee obj : this.employees){
            obj.salary += 0.15 * obj.salary;
        }
    }

    public void printAllEmployees(){
        for(Employee obj : this.employees){
            obj.print();
        }
    }

    public void getBirthdayByName(String  surname) {

        Employee temp = new Employee();


            for (Employee obj : this.employees) {
                if (obj.surname.equals(surname)) {
                    temp = obj;
                    System.out.println("Работник " + surname + " родился в " + temp.birthday + " году");
                    System.out.print("Возраст: ");
                    temp.howOldrU();
                    return;
                }
            }
            System.out.println("Нет работника с фамилией " + surname);


    }


    public static void main(String[] args){
        ArrayList<Employee> e = readFromCsv();
        Task_Executor employees = new Task_Executor(e);
        employees.printAllEmployees();

        System.out.println("--------------------------------------------");
        System.out.println("Увеличим всем зарплату на 15 процентов");
        System.out.println("--------------------------------------------");
        employees.upSalary15per();
        employees.printAllEmployees();
        System.out.println("--------------------------------------------");
        System.out.println("Выведем год рождения работника");
        System.out.println("--------------------------------------------");
        employees.getBirthdayByName("Крючков");
        System.out.println("--------------------------------------------");
        System.out.println("Выведем год рождения работника");
        System.out.println("--------------------------------------------");
        employees.getBirthdayByName("Крючкв");








        //up the salary


    }


}
