package dataBase;

import dataBase.data.User;

import java.sql.*;

public class TestConnector {

//    public Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
//            "student", "student");
    public Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
        "student", "student");
    public Statement myStmnt = this.myConn.createStatement();
    ResultSet myRs = null;

    public TestConnector() throws SQLException {
    }


    public void createDatabaseConnection() throws SQLException{
//        Connection myConn = null;
//        Statement myStmnt = null;
//        ResultSet myRs = null;
        try {
            this.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
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


//
//        String s1 = ex.login;
//        String s2 = ex.password;
//        myStmnt.executeUpdate("insert into User(login, password, address, phone) " +
//                                                   "values (12, \"a\", \"b\", \"c\", 32443);");

    }



    public static void main(String[] args) throws SQLException {
        //createDatabaseConnection();
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                "student", "student");
        User testUser = new User(); //create user
        createUserinDB(testUser);
    }


}
