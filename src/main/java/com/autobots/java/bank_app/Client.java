package com.autobots.java.bank_app;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    private  final String fullName;
    private  final String clientId;
    private  final  String pin;
    private  final List<BankAccount> accountList=new ArrayList<>();

    public Client(String fullName, String pin) {
        this.fullName = fullName;
        this.pin = pin;
        this.clientId=String.valueOf(UUID.randomUUID());
    }

    public boolean authencate(String inputPin){
        return this.pin.equals(inputPin);

    }

    void addAccount (BankAccount account){
        accountList.add(account);
    }

    public String getFullName() {
        return fullName;
    }

    public String getClientId() {
        return clientId;
    }

    public List<BankAccount> getAccountList() {
        return accountList;
    }
}
