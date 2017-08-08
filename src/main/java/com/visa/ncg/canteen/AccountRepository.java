package com.visa.ncg.canteen;

import java.util.HashMap;

public class AccountRepository {
    private HashMap<Long,Account> accountRepository = new HashMap<>();
    private Long nextUniqueId = new Long(0);

    public AccountRepository() {

    }

    public Account save(Account account) {

        if(account.getId() == null) {
            nextUniqueId = new Long(nextUniqueId.longValue()+1);
            account.setAccountId(nextUniqueId);
            accountRepository.put(this.nextUniqueId,account);
        }

        return account;
    }

    public Account findOne(Long accountId) {
        return accountRepository.get(accountId);
    }
}
