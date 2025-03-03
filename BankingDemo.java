//POC 1: Real-World Implementation of OOP (Banking System)
//📌 Problem Statement:

//Design a Banking System using OOP principles. The system should support multiple account types and allow deposits, withdrawals, and balance checks.
//📌 Requirements:

//Create an abstract class BankAccount with attributes accountNumber, accountHolderName, balance.
//Implement concrete classes: SavingsAccount and CurrentAccount.
//Define a method withdraw(double amount), ensuring SavingsAccount maintains a minimum balance.
//Implement deposit(double amount) in the base class.
//Use encapsulation to protect account details.

  //  •        •    Use method overriding for custom withdrawal behavior.



import java.util.*;
  abstract class BankingSystem{
    private long accountNumber;
    private String accountHolderName;
    private double balance;
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }
   
    
    public BankingSystem(long accountNumber, String accountHolderName, double balance2) {
                this.accountNumber = accountNumber;
                this.accountHolderName = accountHolderName;
                this.balance = balance2;
  }
 
       public void deposit(double amount){
      if(amount >0){
          balance+=amount;
          System.out.println("amount Credited");
      }
  }
  public void checkBalance(){
      System.out.println("Account Balance " +balance);
  }
  public abstract void withdraw(double amount);
 
}
class SavingsAccount extends BankingSystem{
private static final double MIN_BALANCE = 500.0;

public SavingsAccount(long accountNumber, String accountHolderName, double balance) {
  super(accountNumber, accountHolderName,  balance);
}
@Override
public void withdraw(double amount){
if(getBalance()-amount>=MIN_BALANCE ){
        super.deposit(amount);

  System.out.println(amount+"debited from your account ,  New Amount :"+getBalance());
}
else{
  System.out.println("Insufficient Balance");
}

}

}
class CurrentAccount extends BankingSystem{
    public CurrentAccount(long accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
           super.deposit(amount);
            System.out.println(amount + " withdrawn. New balance: " + getBalance());
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

public class BankingDemo{
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Account Number: ");
		long accountNumber = sc.nextLong();

		System.out.println("Enter Account Holder Name: ");
		String accountHolderName = sc.next();

		System.out.println("Enter Initial Balance: ");
		double balance = sc.nextDouble();

            System.out.print("Choose Account Type (1: Savings, 2: Current): ");
            int choice = sc.nextInt();
    
            BankingSystem account;
            if (choice == 1) {
                account = new SavingsAccount(accountNumber, accountHolderName, balance);
            } else {
                account = new CurrentAccount(accountNumber, accountHolderName, balance);
            }


    
            while (true) {
                System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
                System.out.print("Choose an option: ");
                int option = sc.nextInt();
    
                if (option == 1) {
                    System.out.print("Enter deposit amount: ");
                    double amount = sc.nextDouble();
                    account.deposit(amount);
                } else if (option == 2) {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = sc.nextDouble();
                    account.withdraw(amount);
                } else if (option == 3) {
                    System.out.println("Current Balance: " + account.getBalance());
                } else if (option == 4) {
                    System.out.println("Thank you for banking with us!");
                    break;
                } else {
                    System.out.println("Invalid choice, please try again.");
                }
            }
            sc.close();
        }
    }
    
           

        
       
      

    

