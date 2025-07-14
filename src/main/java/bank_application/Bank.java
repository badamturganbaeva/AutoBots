package bank_application;

public interface Bank {


    double getBalance();
    void deposit(double amount);
    void withDraw(double amount); //снять деньги

    static  void transferFuds(Bank sender,Bank recipient,double transferAmount){
        sender.withDraw(transferAmount);
        recipient.deposit(transferAmount);
    }

}
