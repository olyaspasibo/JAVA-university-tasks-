package part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

//Операторы цикла с предусловием и постусловием
public class Task2 {
    //Найти все числа некратные пяти и кратные 3, и сумма цифр которых также некратные пяти и кратна 3.

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void task1(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String[] s_A = reader.readLine().split(" ");
        int[] arrInt =new int[s_A.length];
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < arrInt.length; i++) {
            Integer ex = Integer.parseInt(s_A[i]);
            if (ex % 5 != 0 && ex % 3 == 0 &&  sumOfDigits(ex) % 5 != 0 && sumOfDigits(ex) % 3 == 0) {
                arrayList.add(ex);
            }
        }
        System.out.println(arrayList);
    }

    //Найти все числа кратные пяти для чисел от 1 до N
    public static void task2(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        N = N - (N % 5);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (N > 0){
            arrayList.add(N);
            N -= 5;
        }
        System.out.println(arrayList);
    }

    //Является ли заданное натуральное число степенью двойки?
    public static void task3(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input num: ");
        int num = in.nextInt();

        while (num != 1 && num % 2 == 0) {
            num /= 2;
        }

        System.out.println(num == 1 ? "YES" : "NO");
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.print("Input num: ");
        int N = in.nextInt();

        ArrayList<Integer> ans = new ArrayList<Integer>();

        Integer c = 0;
        if (N < 1){
            System.out.println(" ");

        }
        else if (N == 1){
            c = 1;
            ans.add(1);
            ans.add(1);
        }

        else{
            ans.add(1);
            ans.add(1);
            int i = 2;


            while (c < N){
                c = ans.get(i - 1) + ans.get(i - 2);
                ans.add(c);
                i += 1;
            }

        }
        if (ans.get(ans.size() - 1) > N) {
            ans.remove(ans.get(ans.size() - 1));
        }

        System.out.println(ans);
    }


}
