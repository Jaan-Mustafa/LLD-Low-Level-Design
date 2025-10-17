import java.util.ArrayList;
import java.util.List;

interface DepositAccountOnly {
    void deposit(double amount ) ; 
}

interface WithdrawableAccount extends DepositAccountOnly{
    void withdraw(double amount) ; 
}

class SavingAccount implements WithdrawableAccount{
    private double balance ; 
    public SavingAccount(){
        balance =0 ; 
    }

    @Override
    public void deposit(double amount){
        balance+=amount ; 
        System.out.println("Deposited: " + amount + " in Savings Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount){

        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
    }
}

class CurrentAccount implements WithdrawableAccount{

    private double balance ; 
    
    public CurrentAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Current Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Current Account!");
        }
    }
}

class FixedTermAccount implements DepositAccountOnly{
    private double balance;

    public FixedTermAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Fixed Term Account. New Balance: " + balance);
    }
}
// basically ye ek client he aur ham isko pass kar rhe he list 
// of  accounts 
class BankClient{
    private List<WithdrawableAccount> withdrawableAccounts ; 
    private List<DepositAccountOnly> depositOnlyAccounts ; 

    public BankClient( List<WithdrawableAccount> withdrawableAccountss , List<DepositAccountOnly> depositOnlyAccountss){

        this.withdrawableAccounts= withdrawableAccountss ; 
        this.depositOnlyAccounts= depositOnlyAccountss ; 

    }

    public void processTransactions(){
        for( WithdrawableAccount acc : withdrawableAccounts  ){
            acc.deposit(10000);
            acc.withdraw(10000);
        }
        for(DepositAccountOnly acc : depositOnlyAccounts){
            acc.deposit(1000000);
        }
    }
}



public class LSPFollowed {

    public static void main(String[] args){

        List<WithdrawableAccount> withdrawableAccounts= new ArrayList<>() ; 
        withdrawableAccounts.add(new SavingAccount()); 
        withdrawableAccounts.add(new CurrentAccount()) ; 

        List<DepositAccountOnly> depositAccounts= new ArrayList<>() ; 
        depositAccounts.add(new FixedTermAccount()); 


        BankClient client = new BankClient( withdrawableAccounts, depositAccounts) ; 
        client.processTransactions();
         



    }
    
}
