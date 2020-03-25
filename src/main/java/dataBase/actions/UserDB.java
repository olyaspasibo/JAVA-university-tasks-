package dataBase.actions;

import dataBase.data.Account;
import dataBase.data.User;

import java.sql.*;

public class UserDB {

    public static void createUserinDB(User ex)throws SQLException{
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                "student", "student");
        Statement myStmnt = myConn.createStatement();
        // Вам понадобится сам sql запрос
        String sql = "INSERT INTO User (login, password, address, phone) VALUES ((?), (?), (?), (?))";

        //Создаете PreparedStatement что-бы не забыть закрыть лучше открывать в try-with-resources
        final PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setString(1, ex.login);
        statement.setString(2, ex.password);
        statement.setString(3, ex.address);
        statement.setString(4, ex.phone);

        //Выполняете сам запрос в базу.
        statement.executeUpdate();
    }

    public static void findUser(String login, String password)throws SQLException {
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                "student", "student");
        String sql = "select count(*) from  User where User.login = (?) and User.password = (?);";
        final PreparedStatement statement = myConn.prepareStatement(sql);

        statement.setString(1, login);
        statement.setString(2, password);

        ResultSet myRs = statement.executeQuery();

        while(myRs.next()){
            if (myRs.getInt(1) == 1) {
                System.out.println("You are successfully logged in!");
                return;
            } else if (myRs.getInt(1) > 1) {
                System.out.println("WARNING! Database has duplicates. Sorry, system now is unavailable");
                return;
            }
        }
        System.out.println("No user with such credentials");
    }


    public static boolean findUserByLogin(String login)throws SQLException{
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                "student", "student");
        String sql = "select count(*) from  User where User.login = (?);";
        final PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setString(1, login);
        ResultSet myRs = statement.executeQuery();
        while(myRs.next()){
            if (myRs.getInt(1) == 1) {
                System.out.println("User with " + login + " login already exists");
                return false;
            } else if (myRs.getInt(1) > 1) {
                System.out.println("WARNING! Database has duplicates. Sorry, system now is unavailable");
                return false;
            }
        }
        return true;

    }


    public static boolean findUserByPhone(String phone)throws SQLException{
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                "student", "student");
        String sql = "select count(*) from  User where User.phone = (?);";
        final PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setString(1, phone);
        ResultSet myRs = statement.executeQuery();
        while(myRs.next()){
            if (myRs.getInt(1) == 1) {
                //System.out.println("User for " + phone + " phone number already exists");
                return false;
            } else if (myRs.getInt(1) > 1) {
                System.out.println("WARNING! Database has duplicates. Sorry, system now is unavailable");
                return false;
            }
        }
        return true;
    }
    public static String getIdByLogin(String login) throws SQLException {
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                "student", "student");
        String sql = "select * from  User where User.login = (?);";
        final PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setString(1, login);
        ResultSet myRs = statement.executeQuery();
        String id = "";
        while(myRs.next()){
            id = myRs.getString("idUser");
        }
        return id;

    }

    public static String getIdByPhone(String phone) throws SQLException {
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                "student", "student");
        String sql = "select * from  User where User.phone = (?);";
        final PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setString(1, phone);
        ResultSet myRs = statement.executeQuery();
        String id = "";
        while(myRs.next()){
            id = myRs.getString("idUser");
        }
        return id;

    }


    public static Account findAccountByLogin(String login)throws SQLException {
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                "student", "student");
        String example_id = getIdByLogin(login);
        String sql = "select * from  Account where Account.client_id = (?);";

        final PreparedStatement statement = myConn.prepareStatement(sql);

        statement.setString(1, example_id);
        ResultSet myRs = statement.executeQuery();

        Double amount = Double.parseDouble(myRs.getString("amount"));
        Integer accCode = Integer.parseInt(myRs.getString("accCode"));

        return new Account(Integer.parseInt(example_id), amount, accCode);

    }

    public static Account findAccountByPhone(String phone)throws SQLException {
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                "student", "student");
        String example_id = getIdByPhone(phone);
        String sql = "select * from  Account where Account.client_id = (?);";

        final PreparedStatement statement = myConn.prepareStatement(sql);

        statement.setString(1, example_id);
        ResultSet myRs = statement.executeQuery();

        Double amount = Double.parseDouble(myRs.getString("amount"));
        Integer accCode = Integer.parseInt(myRs.getString("accCode"));

        return new Account(Integer.parseInt(example_id), amount, accCode);

    }

}
