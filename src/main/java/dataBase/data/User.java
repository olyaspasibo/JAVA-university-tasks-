package dataBase.data;


import java.sql.SQLException;
import java.util.Scanner;

import static dataBase.TestConnector.findUserByLogin;
import static dataBase.TestConnector.findUserByPhone;

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

    public User() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter your login: ");
        String login = loginCheckUp();
        System.out.print("Please, enter your password: ");
        String password = passwordCheckUp();
        System.out.print("Address: ");
        String address = in.next();
        System.out.print("Your phone number: ");
        String phone = PhoneCheckUp();
        this.login = login;
        this.password = password;
        this.address = address;
        this.phone = phone;

    }

    public static String passwordCheckUp(){
        Scanner in = new Scanner(System.in);
        String password;
        while (true) {
            password = in.next();
            if (password.length() < 5) {
                System.out.println("Минимальная длина пароля - 5 символов");
            }else if (!password.matches("[a-zA-Z0-9_*.]+")) {
                System.out.println("Пароль содержит недопустимые символы");
            }
            else break;
        }
        return password;
    }

    public static String loginCheckUp() throws SQLException {
        Scanner in = new Scanner(System.in);
        String login;
        while (true) {
            login = in.next();
            if (login.length() < 5) {
                System.out.println("Минимальная длина логина - 5 символов");
            }else if (!login.matches("[a-zA-Z0-9_*.]+")) {
                System.out.println("Логин содержит недопустимые символы");
            }
            //пользователь уже зарегистрирован в системе
            else if (findUserByLogin(login)) {
                break;
            }
            //else break;
        }
        return login;
    }

    public static String PhoneCheckUp() throws SQLException {
        Scanner in = new Scanner(System.in);
        String phone;
        while (true) {
            phone = in.next();
            if (phone.length() < 11) {
                System.out.println("Минимальная длина номера телефона 11 символов");
            }

            else if (phone.length() == 11 && phone.charAt(0)!= '8') {
                System.out.println("Ошибка в номере телефона");
            }
            else if (phone.length() == 12 && phone.charAt(0)!= '+' && phone.charAt(1)!= '7') {
                System.out.println("Ошибка в номере телефона");
            }
            else if (phone.length() > 12) {
                System.out.println("Введено слишком много символов");
            }
            else if (!phone.matches("[0-9+]+")) {
                System.out.println("Номер телефона содержит недопустимые символы");
            }
            //пользователь уже зарегистрирован в системе
            else if (findUserByPhone(phone)) {
                //continue;
                break;
            }
            //else break;
        }

        return phone;
    }

    public static void signIn(){
        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter your login: ");
        String login = in.next();
        System.out.print("Please, enter your password: ");
        String password = in.next();
    }


}
