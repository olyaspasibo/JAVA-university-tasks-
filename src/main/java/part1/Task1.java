package part1;


import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;


public class Task1 {
    public static void main2(String[] args) throws IOException {
        // write your code here
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        Integer a = Integer.parseInt(reader.readLine());
        Integer b = Integer.parseInt(reader.readLine());
        if (a * a + b * b > Math.pow((a + b), 2)) {
            System.out.println("Sum of squares is greater");
        } else {
            System.out.println("Square of sums is greater");
        }

    }

    public static void task2(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        Integer experience = Integer.parseInt(reader.readLine());
        Integer salary = Integer.parseInt(reader.readLine());
        if (experience > 2 && experience < 5) {

            System.out.println("New salary " + salary * 1.02);

        } else if (experience >= 5 && experience < 10) {
            System.out.println("New salary " + salary * 1.05);
        } else {
            System.out.println("Wrong parameters input");
        }

    }

    public static void task3(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String[] s_A = reader.readLine().split(" ");
        Integer[] A = new Integer[]{Integer.parseInt(s_A[0]), Integer.parseInt(s_A[1])};
        String[] s_B = reader.readLine().split(" ");
        Integer[] B = new Integer[]{Integer.parseInt(s_B[0]), Integer.parseInt(s_B[1])};
        Double dist_A = Math.sqrt(Math.pow(A[0] - 0, 2) + Math.pow(A[1] - 0, 2));
        Double dist_B = Math.sqrt(Math.pow(B[0] - 0, 2) + Math.pow(B[1] - 0, 2));
        if (dist_A > dist_B) {
            System.out.println("Точка А больше удалена отначала координат");
        }
        else if (dist_A < dist_B) {
            System.out.println("Точка В больше удалена отначала координат");
        }
        else {
            System.out.println("Точки А и В равноудаленные");
        }

    }

    //прямоугольный треугольник
    public static void task4(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int x2 = in.nextInt();
        int x3 = in.nextInt();
        int index_c = -1;
        if (x1 > x2 && x1 > x3) {
            int c = x1;
            index_c = 0;

        }
        else if (x2 > x1 && x2 > x3) {
            int c = x2;
            index_c = 1;

        }
        else if (x3 > x2 && x3 > x1) {
            int c = x3;
            index_c = 2;

        }
        Integer [] arr = {x1, x2, x3};
        if (index_c == -1){
            System.out.println("Error input");
        }
        else if (Math.pow(arr[index_c], 2)  == Math.pow(arr[(index_c + 1) % 3], 2) +
                Math.pow(arr[(index_c + 2) % 3], 2)) {
            System.out.println("Треугольник прямоугольный");
        }
        else {
            System.out.println("Треугольник НЕ прямоугольный");

        }

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int type = in.nextInt();
        switch (type) {
            case 12:
            case 1:
            case 2:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Осень");
                break;
            default:
                System.out.println("Введен некорректный месяц");
                break;
        }

    }
}

