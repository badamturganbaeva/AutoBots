package com.autobots.java.bank_app;

import java.time.LocalDateTime;

public class Transaction {
    private  final  String type; //виды транзакции
    private  final double amount; //сумма
    private  final LocalDateTime dateTime=LocalDateTime.now();// в какое время

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s9: %.2f", dateTime,type,amount );

    }
}
