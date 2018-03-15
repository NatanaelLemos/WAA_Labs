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
public class ListAccountsBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private IAccountService service = new AccountService();

    public Collection<Account> getAccounts(){
        return service.getAllAccounts();
    }
}
