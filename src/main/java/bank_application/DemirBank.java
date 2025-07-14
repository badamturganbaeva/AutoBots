package bank_application;

import static bank_application.BankBase.addToAllBankRecords;

public class DemirBank extends BankBase{

    private  double balance=500;

    public DemirBank(long accountNumber, long routingNumber, double balance) throws Exception {
        super(accountNumber, routingNumber);
        this.balance = balance;
        addToAllBankRecords(this);
    }

    public DemirBank(long accountNumber, int routingNumber) throws Exception {
        super(accountNumber, routingNumber);
        this.balance = balance;
        addToAllBankRecords(this);
    }


    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount<0 || amount>=500000){
            throw new IllegalArgumentException("Invalid amount can not be deposit");
        }
        balance+=amount;
    }

    @Override
    public void withDraw(double amount) {
        if (amount<0||amount>=350000){
            throw new IllegalArgumentException("Invalid amount cant not be with draw");
        }else{
            if (amount>balance){
                throw new IllegalArgumentException(" Insufficient funds");
            }else{
                balance-=amount;
            }
        }

    }
}


