class Account{
    private double balance;

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }
}


public class Encapsulation {
    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(1000);
        System.out.println("Balance: " + account.getBalance()); 
    }
}
