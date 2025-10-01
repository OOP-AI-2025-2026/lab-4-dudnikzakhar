package ua.opnu;
import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

public class MinMaxAccount extends BankingAccount {
    private int maxClientBalance;
    private int minClientBalance;
    public MinMaxAccount(Startup s) {
        super(s);
        this.maxClientBalance = getBalance();
        this.minClientBalance = getBalance();


    }

    public int getMin() {
        return minClientBalance;

    }

    public int getMax() {
        return maxClientBalance;
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);
        int newBalance = getBalance();
        if (newBalance < minClientBalance) {
            minClientBalance = newBalance;
        } else if (newBalance > maxClientBalance) {
            maxClientBalance = newBalance;
        }

    }

    @Override
    public void credit(Credit c) {
        super.credit(c);
        int newBalance = getBalance();
        if (newBalance < minClientBalance) {
            minClientBalance = newBalance;
        } else if (newBalance > maxClientBalance) {
            maxClientBalance = newBalance;
        }

    }
}
