package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill extends GroceryBill {
    private boolean regularCustomer;
    private double discountAmount;
    private int discountedCount;
    private double discountedTotal;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountAmount = 0.0;
        this.discountedCount = 0;
        this.discountedTotal = 0.0;

    }

    @Override
    public void add(Item i) {
        super.add(i);

        if (regularCustomer && i.getDiscount() > 0) {
            discountAmount += i.getDiscount();
            discountedCount++;
            discountedTotal += (i.getPrice() - i.getDiscount());
        } else {
            discountedTotal += i.getPrice();
        }
    }

    @Override
    public double getTotal() {
        return this.discountedTotal;

    }

    public int getDiscountCount() {
        return this.discountedCount;

    }

    public double getDiscountAmount() {
        return this.discountAmount;

    }

    public double getDiscountPercent() {
        if (regularCustomer) {
            if (super.getTotal() != 0) {
                return (100 - ((getTotal() * 100) / super.getTotal()));
            }
        }
        return 0;

    }
}
