package LAB211week6;

import java.util.ArrayList;

public class Order {
    private String customerName;
    private ArrayList<OrderItem> items;

    public Order(String customerName, ArrayList<OrderItem> items) {
        this.customerName = customerName;
        this.items = items;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public ArrayList<OrderItem> getItems() { return items; }
    public void setItems(ArrayList<OrderItem> items) { this.items = items; }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getAmount();
        }
        return total;
    }
} 