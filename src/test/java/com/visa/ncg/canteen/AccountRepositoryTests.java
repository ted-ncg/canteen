package com.visa.ncg.canteen;

import com.visa.ncg.canteen.data.AccountRepositoryInMemory;
import com.visa.ncg.canteen.domain.Account;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountRepositoryTests {

    @Test
    public void createdAccountHasID() throws Exception {
        Account account = new Account("savings", 100);
        AccountRepositoryInMemory repo = new AccountRepositoryInMemory();
        repo.save(account);
        assertThat(account.getId()).isNotEqualTo(null);
    }


    @Test
    public void foundExistingAccount(){
        Account account = new Account("savings", 100);
        AccountRepositoryInMemory repo = new AccountRepositoryInMemory();
        repo.save(account);
        Account retrievedAccount = repo.findOne(account.getId());
        assertThat(retrievedAccount.getId()).isEqualTo(account.getId());
    }

    @Test
    public void didNotFindNonexistentAccount() {
        Account account = new Account("savings", 100);
        AccountRepositoryInMemory repo = new AccountRepositoryInMemory();
        repo.save(account);
        Account retrievedAccount = repo.findOne(2);
        assertThat(retrievedAccount).isEqualTo(null);
    }

    @Test
    public void foundAllAccounts() {
        Account account1 = new Account("savings", 100);
        Account account2 = new Account("savings", 200);
        Account account3 = new Account("savings", 300);
        AccountRepositoryInMemory repo = new AccountRepositoryInMemory();
        repo.save(account1);
        repo.save(account2);
        repo.save(account3);
        List<Account> retrievedAccounts = repo.findAll();
        assertThat(retrievedAccounts.size()).isEqualTo(3);
    }
}
