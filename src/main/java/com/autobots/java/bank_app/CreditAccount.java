package com.autobots.java.bank_app;

public class CreditAccount extends BankAccount{

    private  final  double creditLimit=1000;

    public CreditAccount(Client owner, Currency currency) {
        super(owner, currency);
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
        addTransaction("deposit", amount);

    }

    @Override
    public boolean withDraw(double amount) {
        if (amount<=balance+creditLimit){
            balance-=amount;
            addTransaction("witdraw",amount);
            return true;
        }
        return false;
    }
}
