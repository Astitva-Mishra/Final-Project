import java.util.Scanner;

class ATM {
    float balance;
    int pin = 1234;

    public void checkpin() {
        System.out.println("Enter Your Pin");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();
        if (enteredPin == pin) {
            menu();
        } else {
            System.out.println("Incorrect Pin");
            checkpin();
        }
        sc.close();
    }

    public void menu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
        System.out.println("Choose an option:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                checkbalance();
                menu();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                System.out.println("Thank you for using the ATM.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                menu();
        }
        sc.close();
    }

    public void checkbalance() {
        System.out.println("Your balance is: " + balance);
    }

    public void withdraw() {
        System.out.println("Enter amount to withdraw:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance = balance - amount;
            System.out.println("Please collect your cash.");
            checkbalance();
        }
        menu();
        sc.close();
    }

    public void deposit() {
        System.out.println("Enter amount to deposit:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        balance = balance + amount;
        System.out.println("Your Money has been deposited.");
        checkbalance();
        menu();
        sc.close();
    }
}

public class Project {

    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkpin();
    }
}