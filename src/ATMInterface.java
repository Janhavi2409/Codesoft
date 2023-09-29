import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private final BankAccount account;
    private final Scanner sc = new Scanner(System.in);

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Select an option (1/2/3/4): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Amount: $" + withdrawAmount);
                    } else {
                        System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    if (account.deposit(depositAmount)) {
                        System.out.println("Deposit successful. Amount: $" + depositAmount);
                    } else {
                        System.out.println("Deposit failed. Invalid amount.");
                    }
                }
                case 3 -> {
                    double balance = account.checkBalance();
                    System.out.println("Account Balance: $" + balance);
                }
                case 4 -> {
                    System.out.println("Thank you for using the ATM.");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        double initialBalance = 100000;
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}

