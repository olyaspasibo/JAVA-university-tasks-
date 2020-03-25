package dataBase.actions;

import dataBase.data.Account;

import java.sql.*;

public class AccountDB {

    public static void  createAccountInDB(Account ex)throws SQLException {
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                "student", "student");
        Statement myStmnt = myConn.createStatement();
        // Вам понадобится сам sql запрос
        String sql = "INSERT INTO Account (client_id, amount, accCode) VALUES ((?), (?), (?))";

        //Создаете PreparedStatement что-бы не забыть закрыть лучше открывать в try-with-resources
        final PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setInt(1, ex.clientId);
        statement.setDouble(2, ex.amount);
        statement.setInt(3, ex.accCode);

        //Выполняете сам запрос в базу.
        statement.executeUpdate();
    }

    //пополнить счет
    public static void addToAmountDB(Account ex) throws SQLException {
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                "student", "student");
        Statement myStmnt = myConn.createStatement();

        String sql = "UPDATE Account SET Account.amount = (?)";

        //Создаете PreparedStatement что-бы не забыть закрыть лучше открывать в try-with-resources
        final PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setDouble(1, ex.amount);


        //Выполняете сам запрос в базу.
        statement.executeUpdate();
    }




    }


