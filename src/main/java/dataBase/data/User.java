package dataBase.data;


import java.util.Scanner;

public class User {
    public String login;
    public String password;
    public String address;
    public String phone;

    public User(String login, String password, String address, String phone){
        this.login = login;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    public String getLogin() {
        return this.login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(){
        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter your login: ");
        String login = in.next();
        System.out.print("Please, enter your password: ");
        String password = in.next();
        System.out.print("Address: ");
        String address = in.next();
        System.out.print("Your phone number: ");
        String phone = in.next();
        this.login = login;
        this.password = password;
        this.address = address;
        this.phone = phone;

    }

    public static void signIn(){
        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter your login: ");
        String login = in.next();
        System.out.print("Please, enter your password: ");
        String password = in.next();
    }


}
