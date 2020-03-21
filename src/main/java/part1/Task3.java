package part1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Оператор цикла с параметром
public class Task3 {
    public static void task1(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input num: ");
        int A = in.nextInt();
        int B = in.nextInt();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = A; i <= B; i += 1){
            ans.add(i);

        }
        System.out.println("Числа: " + ans);
        System.out.println("Количество чисел: " + ans.size());
    }

    public static void task2(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input num: ");
        int A = in.nextInt();
        int B = in.nextInt();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = B - 1; i > A; i -= 1){
        ans.add(i);

        }
        System.out.println("Числа: " + ans);
        System.out.println("Количество чисел: " + ans.size());
    }


    //Дано вещественное число A и целое число N (> 0). Найти A в степени N: AN = A•A••A
    // (числа A перемножаются N раз)
    public static void task3(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input num: ");
        double A = in.nextDouble();
        int N = in.nextInt();
        double res = A;

        while (N > 1) {
            res *= A;
            N -= 1;
        }
        System.out.println(res);
    }

    //Дано вещественное число A и целое число N (> 0). Найти все целые степени числа A от 1 до N.
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input num: ");
        double A = in.nextDouble();
        int N = in.nextInt();
        ArrayList<Double> ans = new ArrayList<Double>();
        double c = A;
        for (int i = 1; i <= N; i++) {
            ans.add(c);
            c *= A;
        }

        System.out.println(ans);
    }

}
