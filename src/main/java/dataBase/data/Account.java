package dataBase.data;

import java.sql.SQLException;
import java.util.Scanner;

import static dataBase.actions.AccountDB.addToAmountDB;

public class Account {
    public static Integer clientId;
    public static Double amount;
    public static Integer accCode;

    public Account(){}

    public Account(Integer clientId, Double amount, Integer accCode){
        Account.clientId = clientId;
        Account.amount = amount;
        Account.accCode = accCode;

    }

    public static void setAmount(Double amount) {
        Account.amount = amount;
    }

    //пополнить счет
    public void addToAmount(Double amount) throws SQLException {

        Account.amount += amount;
        addToAmountDB(this);
    }

    public static void setAccCode(Integer accCode) {
        Account.accCode = accCode;
    }

    public static Integer checkAccCode(){
        Scanner in = new Scanner(System.in);

        while (true) {
            Integer accCode = in.nextInt();
            if (accCode == 1 || accCode == 2 || accCode == 3)
                return accCode;
            else {
                System.out.println("Введите корректный идентификатор валюты");
            }
        }


    }
    public static Double checkAmount(){
        Scanner in = new Scanner(System.in);

        while (true) {
            try{
                Double amount = in.nextDouble();
                if (amount <= 0) {
                    System.out.println("Сумма не может быть отрицательной");
                }
                return amount;
            }
            catch (Exception e) {

            }
        }

    }

    public boolean moneyAmountIsEnough(Double sum){
        if (this.amount < sum){
            System.out.println("На вашем счете недостаточно средств");
            return false;
        }
        return true;
    }


}
