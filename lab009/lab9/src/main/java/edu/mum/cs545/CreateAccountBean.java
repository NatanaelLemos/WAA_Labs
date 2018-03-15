package edu.mum.cs545;

import cs545.bank.domain.Account;
import cs545.bank.service.AccountService;
import cs545.bank.service.IAccountService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@SessionScoped
public class CreateAccountBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String customerName;
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    private long accountNumber;
    public long getAccountNumber() { return accountNumber; }
    public void setAccountNumber(long accountNumber) { this.accountNumber = accountNumber; }

    private double initialBalance;
    public double getInitialBalance() { return initialBalance; }
    public void setInitialBalance(double initialBalance) { this.initialBalance = initialBalance; }

    private IAccountService service = new AccountService();

    public String createAccount(){
        Account account = service.createAccount(accountNumber, customerName);
        account.deposit(initialBalance);
        return "success";
    }
}
