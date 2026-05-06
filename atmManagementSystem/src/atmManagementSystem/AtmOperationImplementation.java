package atmManagementSystem;

import java.io.*;
import java.util.*;

public class AtmOperationImplementation implements AtmInterface {
    private Map<String, User> users;
    private User currentUser;
    private static final String DATA_FILE = "users.properties";

    public AtmOperationImplementation() {
        this.users = new HashMap<>();
        loadUserData();
    }

    public boolean login(String accountNumber, String pin) {
        User user = users.get(accountNumber);
        if (user != null && user.getPin().equals(pin)) {
            this.currentUser = user;
            System.out.println("Login successful!");
            return true;
        }
        System.out.println("Invalid account number or PIN.");
        return false;
    }

    @Override
    public void viewBalance() {
        if (currentUser != null) {
            System.out.printf("Available Balance is: $%.2f%n", currentUser.getBalance());
        }
    }

    public void withdrawAmount(double withdrawAmount) {
        if (currentUser == null) return;
        if (withdrawAmount > currentUser.getBalance()) {
            System.out.println("Insufficient Balance!");
        } else {
            currentUser.setBalance(currentUser.getBalance() - withdrawAmount);
            currentUser.addTransaction(new Transaction("Withdrawal", -withdrawAmount));
            System.out.printf("Collect your cash: $%.2f%n", withdrawAmount);
            viewBalance();
            saveUserData();
        }
    }

    public void depositAmount(double depositAmount) {
        if (currentUser == null) return;
        currentUser.setBalance(currentUser.getBalance() + depositAmount);
        currentUser.addTransaction(new Transaction("Deposit", depositAmount));
        System.out.printf("$%.2f Deposited Successfully!%n", depositAmount);
        viewBalance();
        saveUserData();
    }

    public void viewMiniStatement() {
        if (currentUser == null) return;
        System.out.println("\n--- Mini Statement ---");
        System.out.printf("%-15s | %-10s | %s%n", "Type", "Amount", "Date/Time");
        System.out.println("-------------------------------------------------");
        
        List<Transaction> history = currentUser.getTransactionHistory();
        if (history.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : history) {
                System.out.println(transaction);
            }
        }
        System.out.println("-------------------------------------------------");
    }

    // New methods for data persistence
    private void loadUserData() {
        try (InputStream input = new FileInputStream(DATA_FILE)) {
            Properties prop = new Properties();
            prop.load(input);

            for (String key : prop.stringPropertyNames()) {
                if (key.endsWith(".pin")) {
                    String accountNumber = key.substring(0, key.indexOf("."));
                    String pin = prop.getProperty(key);
                    double balance = Double.parseDouble(prop.getProperty(accountNumber + ".balance", "0.0"));
                    User user = new User(accountNumber, pin, balance);
                    users.put(accountNumber, user);
                }
            }
        } catch (IOException ex) {
            System.out.println("Data file not found. Starting with a default user.");
            // Create a default user if file doesn't exist
            User defaultUser = new User("12345", "1234", 10000.00);
            users.put("12345", defaultUser);
            saveUserData();
        }
    }

    private void saveUserData() {
        try (OutputStream output = new FileOutputStream(DATA_FILE)) {
            Properties prop = new Properties();
            for (User user : users.values()) {
                prop.setProperty(user.getAccountNumber() + ".pin", user.getPin());
                prop.setProperty(user.getAccountNumber() + ".balance", String.valueOf(user.getBalance()));
            }
            prop.store(output, "ATM User Data");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}