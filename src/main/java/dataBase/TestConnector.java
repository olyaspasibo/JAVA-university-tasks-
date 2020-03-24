package dataBase;

import dataBase.data.User;

import java.sql.*;

public class TestConnector {


    public TestConnector() throws SQLException {
    }


    public void createDatabaseConnection() throws SQLException{
        Connection myConn = null;
//        Statement myStmnt = null;
//        ResultSet myRs = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                    "student", "student");
            System.out.println("Database connection is successful!");
//            myStmnt = myConn.createStatement();
//            myRs = myStmnt.executeQuery("select * from Account;");
//            while(myRs.next()){
//                System.out.println(myRs.getString("client_id") + " " +
//                        myRs.getString("amount"));
//            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

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


    public static void findUser(String login, String password)throws SQLException{
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
                System.out.println("User for " + phone + " phone number already exists");
                return false;
            } else if (myRs.getInt(1) > 1) {
                System.out.println("WARNING! Database has duplicates. Sorry, system now is unavailable");
                return false;
            }
        }
        return true;
    }





    public static void main(String[] args) throws SQLException {
        //createDatabaseConnection();
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                "student", "student");
        User testUser = new User(); //create user
        //createUserinDB(testUser);
        //findUser("user6", "qa_test1");

    }


}
