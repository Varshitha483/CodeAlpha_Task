package atmManagementSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        AtmOperationImplementation op = new AtmOperationImplementation();
        Scanner sc = new Scanner(System.in);
        String accountNumber;
        String pin;

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your Account Number: ");
        accountNumber = sc.nextLine();
        System.out.print("Enter your PIN: ");
        pin = sc.nextLine();

        if (op.login(accountNumber, pin)) {
            while (true) {
                try {
                    System.out.println("\n1. View Available Balance\n2. Withdraw Amount\n3. Deposit Amount\n4. View Mini Statement\n5. Exit");
                    System.out.print("Enter your choice: ");
                    int choice = sc.nextInt();
                    
                    switch (choice) {
                        case 1:
                            op.viewBalance();
                            break;
                        case 2:
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = sc.nextDouble();
                            op.withdrawAmount(withdrawAmount);
                            break;
                        case 3:
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = sc.nextDouble();
                            op.depositAmount(depositAmount);
                            break;
                        case 4:
                            op.viewMiniStatement();
                            break;
                        case 5:
                            System.out.println("Thank you for using the ATM. Goodbye!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.next(); // Clear the invalid input from the scanner
                }
            }
        }
        sc.close();
    }
}