package com.autobots.java.bank_app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    static  Scanner scan=new Scanner(System.in);
    static Map<String, Client> clients=new HashMap<>();

    public static void main(String[] args) {

        Client asan=new Client("Asan Uson","1234");
        DepositAccount asanDepositAccount=new DepositAccount(asan,Currency.USD);
        CreditAccount acanCreditAccount=new CreditAccount(asan,Currency.EUR);

        asan.addAccount(asanDepositAccount);
        asan.addAccount(acanCreditAccount);
        System.out.println(asan.getClientId());
        clients.put(asan.getClientId(),asan);

        System.out.println("=========Welcome to MBank=========");
        System.out.print("Please enter client ID");
        String clientId=scan.nextLine();
        Client client=clients.get(clientId);

        if (client==null){
            System.out.println("Client was not found");
            return;
        }
        System.out.println("please enter pin code");
        String pinCode=scan.nextLine();
        if (!client.authencate(pinCode)){
            System.out.println("You entered wrong pin code!");
            return;
        }
        System.out.println(client.getFullName()+ " welcome to Mbank");


        while (true){
            System.out.println(" 1. Посмотреть счета");
            System.out.println(" 2. Перевести между счетами");
            System.out.println(" 3. Показыть чек");
            System.out.println(" 0. Выход из программы");

            String choice=scan.nextLine();

            switch (choice){
                case "1":
                    for (BankAccount bankAccount: client.getAccountList()){
                        System.out.printf("%s| %s | Баланс: %2f %s\n",
                                bankAccount.getClass().getSimpleName(),
                                bankAccount.getAccountNumber(),
                                bankAccount.getBalance(),bankAccount.getCurrency());
                    }break;

                case  "2":
                    System.out.print("Введите номер счета отправителя ");
                    String fromId=scan.nextLine();
                    System.out.println("Введите номер получателя ");
                    String toId=scan.nextLine();
                    System.out.println("Сумма: ");
                    double amount=Double.parseDouble(scan.nextLine());
                    BankAccount from=findAccount(fromId);
                    BankAccount to=findAccount(toId);
                    if (from!=null && to!=null){
                       boolean result=  BankService.transfer(from,to, amount);
                        System.out.println(result ? "успешно" : "ошибка перевода");
                    }else {
                        System.out.println("Счета не найдены");
                    }break;

                case"3":
                    for (BankAccount bankAccount: client.getAccountList()){
                        System.out.println("\n == чек по счету "+ bankAccount.getAccountNumber());
                        for (Transaction transaction: bankAccount.getTransactions()){
                            System.out.println(transaction);
                        }
                    } break;
                    case  "0":
                        System.out.println("Выход: ");
                        return;
                default:
                    System.out.println("Не верный выбор");
            }
        }
    }

    private  static  BankAccount findAccount(String accountNumber){
        for (Client client:clients.values()){
            for (BankAccount bankAccount:client.getAccountList()){
                if (bankAccount.getAccountNumber().equals(accountNumber)){
                    return  bankAccount;
                }
            }
        }
        return null;

    }
}
