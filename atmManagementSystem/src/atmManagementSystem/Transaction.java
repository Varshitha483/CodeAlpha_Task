package atmManagementSystem;

import java.time.LocalDateTime;
import java.io.Serializable;

public class Transaction implements Serializable {
    private String type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("%-15s | $%-10.2f | %s", type, amount, timestamp.toString());
    }
}