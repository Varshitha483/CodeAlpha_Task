package stockTradingPlatform;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<Stock, Integer> holdings;
    private double balance;

    public Portfolio() {
        this.holdings = new HashMap<>();
        this.balance = 10000.0; // default starting balance
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (balance >= cost) {
            holdings.put(stock, holdings.getOrDefault(stock, 0) + quantity);
            balance -= cost;
            System.out.println("Bought " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("Not enough balance to buy " + stock.getSymbol());
        }
    }

    public void sellStock(Stock stock, int quantity) {
        if (holdings.containsKey(stock) && holdings.get(stock) >= quantity) {
            holdings.put(stock, holdings.get(stock) - quantity);
            balance += stock.getPrice() * quantity;
            System.out.println("Sold " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("Not enough shares to sell.");
        }
    }

    public void displayPortfolio() {
        System.out.println("Portfolio Holdings:");
        for (Map.Entry<Stock, Integer> entry : holdings.entrySet()) {
            System.out.println(entry.getKey() + " - Shares: " + entry.getValue());
        }
        System.out.println("Balance: $" + balance);
    }
}