package model.entities;

import model.exceptions.WithdrawException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance, withdrawLimit;
    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        if (number == null || number <= 0) {
            throw new IllegalArgumentException("Account number must be greater than zero");
        }
        if (holder == null) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }
        if (balance == null || balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        if (withdrawLimit == null || withdrawLimit < 0) {
            throw new IllegalArgumentException("Withdraw limit cannot be negative");
        }
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        if(amount == null || amount <= 0){
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }
        this.balance += amount;
    }

    public void withdraw(Double amount){
        if (amount <= 0){
            throw new WithdrawException("The amount must be greater than zero");
        } else if(amount > this.withdrawLimit){
            throw new WithdrawException("The amount exceeds withdraw limit");
        } else if(amount > this.balance){
            throw new WithdrawException("Not enough balance");
        }
        this.balance -= amount;
    }

}
