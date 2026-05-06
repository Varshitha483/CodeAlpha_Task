package stockTradingPlatform;

import java.util.Scanner;

public class TradingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Market market = new Market();
        User user = new User("Varshitha");

        while (true) {
            System.out.println("\n===== Stock Trading Platform =====");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    market.displayMarket();
                    break;

                case 2:
                    market.displayMarket();
                    System.out.print("Enter Stock Symbol to Buy: ");
                    String buySymbol = sc.next();
                    Stock buyStock = market.findStock(buySymbol);
                    if (buyStock != null) {
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();
                        user.getPortfolio().buyStock(buyStock, qty);
                    } else {
                        System.out.println("Stock not found.");
                    }
                    break;

                case 3:
                    user.getPortfolio().displayPortfolio();
                    System.out.print("Enter Stock Symbol to Sell: ");
                    String sellSymbol = sc.next();
                    Stock sellStock = market.findStock(sellSymbol);
                    if (sellStock != null) {
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();
                        user.getPortfolio().sellStock(sellStock, qty);
                    } else {
                        System.out.println("Stock not found.");
                    }
                    break;

                case 4:
                    user.getPortfolio().displayPortfolio();
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

