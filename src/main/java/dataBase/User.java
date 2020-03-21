package dataBase;


import java.util.Scanner;

public class User {
    public static String login;
    public static String password;
    public static String address;
    public static String phone;

    public User(String login, String password, String address, String phone){
        User.login = login;
        User.password = password;
        User.address = address;
        User.phone = phone;
    }

    public static String getLogin() {
        return login;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static void setAdress(String address) {
        User.address = address;
    }

    public static void setPhone(String phone) {
        User.phone = phone;
    }

    public static User signUp(){
        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter your login: ");
        String login = in.next();
        System.out.print("Please, enter your password: ");
        String password = in.next();
        System.out.print("Address: ");
        String address = in.next();
        System.out.print("Your phone number: ");
        String phone = in.next();
        User newUser = new User(login, password, address, phone);
        return  newUser;
    }

    public static void signIn(){
        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter your login: ");
        String login = in.next();
        System.out.print("Please, enter your password: ");
        String password = in.next();
    }


}
