package src.main.model.account;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public abstract class Account {
    
    private String id;
    private String name;
    private double balance;


    public Account(String id, String name, double balance) {
        if (id == null || id.isBlank() || name == null || name.isBlank()){
            throw new IllegalArgumentException("Id or Name cannot be empty or null");
        }
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public Account(Account source) {
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()){
            throw new IllegalArgumentException("invalid id");
        }
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName()) + "    " +
            "\t" + this.getId() + "" +
            "\t" + this.getName() + "" +
            "\t$" + this.getBalance() + "";
    }

    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);

    protected double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
        return Double.parseDouble(formatter.format(amount));
    }
    

}
