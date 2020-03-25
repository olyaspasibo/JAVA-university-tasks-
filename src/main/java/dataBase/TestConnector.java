package dataBase;

import dataBase.data.Account;
import dataBase.data.User;

import java.sql.*;

import static dataBase.actions.UserDB.*;
import static dataBase.data.User.signIn;

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







    public static void main(String[] args) throws SQLException {

        //создание пользователя
        //User testUser = new User(); //create user

        User testUser2 = new User("olya.spasibo", "secret", "Saratov,Russia", "89271280405"); //create user
        createUserinDB(testUser2);

        //авторизация

        //signIn();

        //создание аккаунта у залогированного пользователя

        Account testUser2Acc = testUser2.createAccount();

        //пополнение счета

        testUser2Acc.addToAmount(1500.0);


        //перевод средств по номеру телефона другому аккаунту
        String phone = "89271280405";
        Account testUser2Account = findAccountByLogin(testUser2.login);
        Account testUser3Account = findAccountByPhone(phone);
        Double sumOfTransaсtion = 1000.0;
        //check that money enough
        if (testUser2Account.moneyAmountIsEnough(sumOfTransaсtion)){

            testUser2Account.addToAmount(-sumOfTransaсtion);

            testUser3Account.addToAmount(sumOfTransaсtion);


        }




        //просмотр истории операций по клиенту
        //createDatabaseConnection();
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                "student", "student");

        findUser("user6", "qa_test1");





    }



}
