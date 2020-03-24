package dataBase.data;

public class Account {
    public static String clientId;
    public static Integer amount;
    public static Integer accCode;

    public Account(String clientId, Integer amount, Integer accCode){
        Account.clientId = clientId;
        Account.amount = amount;
        Account.accCode = accCode;

    }

    public static void setAmount(Integer amount) {
        Account.amount = amount;
    }

    public static void setAccCode(Integer accCode) {
        Account.accCode = accCode;
    }


}
