package part1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Task4 {
    private static HashSet<Integer> intSet = new HashSet<Integer>();

    //Массивы

    //Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести четные и нечетные числа.
    public static void task1(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input num: ");
        int N = in.nextInt();
        ArrayList<Integer> ans_mod2 = new ArrayList<Integer>();
        ArrayList<Integer> ans_not = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int c = in.nextInt();
            if (c % 2 == 0) {
                ans_mod2.add(c);
            }
            else {
                ans_not.add(c);
            }
        }

        System.out.println("Четные числа: " + ans_mod2);
        System.out.println("Нечетные числа: " + ans_not);
    }

    //Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести числа,
    // которые делятся на 3 или на 9
    public static void task2(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input num: ");
        int N = in.nextInt();
        ArrayList<Integer> ans_mod3 = new ArrayList<Integer>();
        ArrayList<Integer> ans_mod9 = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int c = in.nextInt();
            if (c % 9 == 0) {
                ans_mod9.add(c);
            }
            else if (c % 3 == 0){
                ans_mod3.add(c);
            }
        }

        System.out.println("Делятся на 3, но не на 9: " + ans_mod3);
        System.out.println("Делятся на 9: " + ans_mod9);
    }

    //Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести числа,
    // которые делятся на 5 или на 10.
    public static void task3(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input num: ");
        int N = in.nextInt();
        ArrayList<Integer> ans_mod5 = new ArrayList<Integer>();
        ArrayList<Integer> ans_mod10 = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int c = in.nextInt();
            if (c % 10 == 0) {
                ans_mod10.add(c);
            }
            else if (c % 5 == 0){
                ans_mod5.add(c);
            }
        }

        System.out.println("Делятся на 5, но не на 10: " + ans_mod5);
        System.out.println("Делятся на 10: " + ans_mod10);
    }

    //Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести наибольший общий делитель
    // и наименьшее общее кратное этих чисел
    public static int gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    /* Разложение на множители с помощью рекурсии
    Разложить целое число n > 1 на простые множители.
    Вывести в консоль через пробел все множители в порядке возрастания.
    Написать рекуррентный метод для вычисления простых множителей.
    Не создавайте статические переменные и поля класса.
    Пример:
    132
    Вывод на консоль:
    2 2 3 11
    */

    public static void recursion(int n) {
        //HashSet<Integer> intSet = new HashSet<Integer>();
            int a = 2;
            while (a <= n) {
                if ((n % a) == 0) {
                    if (a != n) {
                        System.out.print(a + " ");
                        intSet.add(a);
                        recursion(n / a);
                    } else {
                        System.out.print(a);
                        intSet.add(a);
                    }
                    System.out.println(intSet);
                    return;
                }
                a++;
                //System.out.println(intSet);
            }


        }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input num: ");
        int N = in.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
            int temp = in.nextInt();
            arr.add(temp);
            recursion(temp);
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i: intSet){
            res.add(i);

        }

        int temp = 1;
        for (int i = 0; i < res.size(); i++) {
            temp *= res.get(i);
        }

        System.out.println("Исходный массив: " + arr);
        System.out.println("НОД: " + temp);
//        int temp = arr.get(0);
//        for (int i = 1; i < N; i++) {
//            gcd(temp, arr.get(i))
//        }
//
//        System.out.println("Делятся на 5, но не на 10: " + ans_mod5);
//        System.out.println("Делятся на 10: " + ans_mod10);
    }

}
