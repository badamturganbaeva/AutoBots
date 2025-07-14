package bank_application;

public class Mbank extends BankBase{

    private  double balance=200;

    public Mbank(long accountNumber, long routingNumber) throws Exception {
        super(accountNumber, routingNumber);
        addToAllBankRecords(this);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount<0 || amount>=200000){
            throw new IllegalArgumentException("Invalid amount can not be deposit");
        }
        balance+=amount;
    }

    @Override
    public void withDraw(double amount) {
        if (amount<0||amount>=150000){
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
