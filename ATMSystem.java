import java.util.Scanner;

class ATM {
    private double balance;
    private String transactionHistory = "";
    private final int PIN = 1234;  // Default PIN

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean authenticate(int enteredPin) {
        return enteredPin == PIN;
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory += "Deposited: $" + amount + "\n";
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory += "Withdrew: $" + amount + "\n";
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        System.out.println(transactionHistory.isEmpty() ? "No transactions yet!" : transactionHistory);
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM myATM = new ATM(5000);  // Initial balance

        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (myATM.authenticate(enteredPin)) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    myATM.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    myATM.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    myATM.withdraw(withdrawAmount);
                    break;
                case 4:
                    myATM.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } else {
            System.out.println("Incorrect PIN! Access denied.");
        }
        scanner.close();
    }
}
