package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill2 {
    private boolean regularCustomer;
    private double discountAmount;
    private int discountedCount;

    private GroceryBill bill;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
        this.discountAmount = 0.0;
        this.discountedCount = 0;
    }

    public void add(Item i) {
        bill.add(i);

        if (regularCustomer && i.getDiscount() > 0) {
            discountedCount++;
            discountAmount += i.getDiscount();
        }
    }

    public double getTotal() {
        return (bill.getTotal() - this.discountAmount);

    }

    public int getDiscountCount() {
        return this.discountedCount;

    }

    public double getDiscountAmount() {
        return this.discountAmount;

    }

    public double getDiscountPercent() {
        if (regularCustomer) {
            if (bill.getTotal() != 0) {
                double testTotal = (100 - ((this.getTotal() * 100) / bill.getTotal()));
                return Math.round(testTotal * 10000000000000.0) / 10000000000000.0;
            }
        }
        return 0;

    }

    public Employee getClerk() {
        return bill.getClerk();
    }
}
