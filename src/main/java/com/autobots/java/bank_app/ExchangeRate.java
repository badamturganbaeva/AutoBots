package com.autobots.java.bank_app;

import java.util.Map;

public class ExchangeRate {//обменка
public static  double convert (double amount, Currency from, Currency to){
    if (from==to) return amount;


    Map <Currency,Double> toUSD=Map.of(
            Currency.USD,1.0,
            Currency.EUR,1.1,
            Currency.KGZ, 0.011
    );

double usd= amount* toUSD.get(from);
return usd/toUSD.get(to);



}
}
