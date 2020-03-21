package dataBase;

import java.sql.*;

public class TestConnector {
    public static void main(String[] args) throws SQLException{
        Connection myConn = null;
        Statement myStmnt = null;
        ResultSet myRs = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                    "student", "student");
            System.out.println("Database connection is successful!");
            myStmnt = myConn.createStatement();
            myRs = myStmnt.executeQuery("select * from Account;");
            while(myRs.next()){
                System.out.println(myRs.getString("client_id") + " " +
                        myRs.getString("amount"));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
