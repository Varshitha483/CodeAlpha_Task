package stockTradingPlatform;

import java.util.*;

public class Market {
    private List<Stock> stocks;

    public Market() {
        stocks = new ArrayList<>();
        stocks.add(new Stock("AAPL", "Apple Inc.", 150));
        stocks.add(new Stock("GOOGL", "Alphabet Inc.", 2800));
        stocks.add(new Stock("TSLA", "Tesla Inc.", 700));
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void displayMarket() {
        System.out.println("\n--- Market Data ---");
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
    }

    public Stock findStock(String symbol) {
        for (Stock stock : stocks) {
            if (stock.getSymbol().equalsIgnoreCase(symbol)) {
                return stock;
            }
        }
        return null;
    }
}