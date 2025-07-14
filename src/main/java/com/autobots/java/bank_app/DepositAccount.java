package com.autobots.java.bank_app;

public class DepositAccount extends  BankAccount{


    public DepositAccount(Client owner, Currency currency) {
        super(owner, currency);
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;

        addTransaction("deposit", amount);

    }

    @Override
    public boolean withDraw(double amount) {// снимает деньги с баланса
       if (amount<=balance){
           balance-=amount;
           addTransaction("witdraww",amount);
           return true;
       }
        return false;
    }
}
