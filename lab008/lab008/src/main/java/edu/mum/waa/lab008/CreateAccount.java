package edu.mum.waa.lab008;

import cs545.bank.domain.Account;
import cs545.bank.service.AccountService;
import cs545.bank.service.IAccountService;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
@ManagedBean
@FlowScoped("createAccountFlow")
public class CreateAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    private IAccountService service = new AccountService();

    private long accountnr;
    public long getAccountnr(){ return accountnr; }
    public void setAccountnr(long nr){ this.accountnr = nr; }

    public CreateAccount(){
        Account account = new Account(this.accountnr);
    }
}
