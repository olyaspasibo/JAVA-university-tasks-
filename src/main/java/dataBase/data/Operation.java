package dataBase.data;

import java.sql.*;
import java.util.Date;

public class Operation {

    public Date date;
    public Integer inAccount;
    public Integer outAccount;
    public Double sum;
    public Double beforeTransaction;
    public  Double afterTransaction;

    public void findUserOperations(String userId) throws SQLException {
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                "student", "student");
        Statement myStmnt = myConn.createStatement();

        String sql = "select count(*) from  Operation where Operation.in_account = (?) or Operation.out_account = (?);";
        final PreparedStatement statement = myConn.prepareStatement(sql);

        statement.setString(1, userId);
        statement.setString(2, userId);

        ResultSet myRs = statement.executeQuery();

        while(myRs.next()) {

            System.out.println(myRs.getString("in_account") + " " +
                    myRs.getString("out_account") + " " + myRs.getString("sum") +
                    myRs.getString("before_transaction") + " " +
                    myRs.getString("after_transaction"));
        }





    }
}
