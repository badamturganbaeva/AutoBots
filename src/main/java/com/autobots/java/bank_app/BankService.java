package com.autobots.java.bank_app;

public class BankService {
    public static boolean transfer(BankAccount from, BankAccount to, double amount) {
        if (from.withDraw(amount)) {
            double convertedSum = ExchangeRate.convert(amount, from.getCurrency(), to.getCurrency());
            to.deposit(convertedSum);
            from.addTransaction("trancfer out", amount);
            to.addTransaction("trancfer in", convertedSum);
            return true;
        }
        return false;
    }
}
