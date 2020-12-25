package com.example.bankapplication;

public class Account {
    private String name;
    private String address;
    private String email;
    private String phoneno;
    private String cardnumber;
    private String accounttype;
    private int pin;
    private String accountnumber;
    private double balance;
    public Account(String name, String address,String email, String phoneno, String cardnumber,String accounttype, int pin, String accountnumber, double balance) {
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
        this.cardnumber = cardnumber;
        this.pin = pin;
        this.accountnumber = accountnumber;
        this.balance = balance;
        this.accounttype = accounttype;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
