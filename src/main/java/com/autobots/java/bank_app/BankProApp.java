package com.autobots.java.bank_app;

import java.util.HashMap;
import java.util.Map;

public class BankProApp {
    private static  final Map<String,Client> clients=new HashMap<>();

    public static void main(String[] args) {

        Client asan=new Client("Asan Uson","1234");
        DepositAccount asanDepositAccount=new DepositAccount(asan,Currency.USD);
        CreditAccount acanCreditAccount=new CreditAccount(asan,Currency.EUR);

        asan.addAccount(asanDepositAccount);
        asan.addAccount(acanCreditAccount);
        clients.put(asan.getClientId(),asan);
    }
}
