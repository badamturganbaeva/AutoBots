package bank_application;

public class BamkDemo {
    public static void main(String[] args) throws Exception {

        Mbank mbankBadam=new Mbank(123456789012L,123456789);
        System.out.println(mbankBadam.getBalance());
        mbankBadam.deposit(100000);
        System.out.println(mbankBadam.getBalance());
        System.out.println("____________________");

        OptimaBank optimaBankBadam=new OptimaBank(123456789013L,123456788);
        System.out.println(optimaBankBadam.getBalance());

        Bank.transferFuds(mbankBadam,optimaBankBadam,500);
        System.out.println(mbankBadam.getBalance());
        System.out.println(optimaBankBadam.getBalance());
        System.out.println("_________________");

        DemirBank urmatDemir=new DemirBank(123456781234L,123456543);
//        Bank.transferFuds(urmatDemir,optimaBankBadam,2000);
        System.out.println(urmatDemir.getBalance());
//        urmatDemir.deposit(670000);

        BankBase.allBankRecords.stream().filter(n->n.getBalance()>=100).forEach(System.out::println);

        double allSumOfBanks=BankBase.allBankRecords.stream().mapToDouble(Bank::getBalance).sum();
        System.out.println(allSumOfBanks);





    }
}
