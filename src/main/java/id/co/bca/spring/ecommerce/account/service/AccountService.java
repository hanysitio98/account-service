package id.co.bca.spring.ecommerce.account.service;

import id.co.bca.spring.ecommerce.account.dto.AccountDTO;
import id.co.bca.spring.ecommerce.account.model.Account;

public interface AccountService {

    Account create(AccountDTO accountDTO);

    Account update(AccountDTO accountDTO, Integer id);

    String delete(Integer id);

    Account getAccountById(Integer id);
}
