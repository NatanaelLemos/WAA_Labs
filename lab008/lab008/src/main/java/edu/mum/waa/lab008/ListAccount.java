package edu.mum.waa.lab008;

import cs545.bank.domain.Account;
import cs545.bank.service.AccountService;
import cs545.bank.service.IAccountService;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@SessionScoped
@ManagedBean
public class ListAccount implements Serializable {
    private IAccountService service = new AccountService();

    public Collection<Account> getAccounts() {
        return service.getAllAccounts();
    }
}
