package id.co.bca.spring.ecommerce.account.service;

import id.co.bca.spring.ecommerce.account.dto.AccountDTO;
import id.co.bca.spring.ecommerce.account.model.Account;
import id.co.bca.spring.ecommerce.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    AccountRepository accountRepository;


    @Override
    public Account create(AccountDTO accountDTO) {
        Account model = new Account();
        model.setName(accountDTO.getName());
        model.setEmail(accountDTO.getEmail());
        model.setUsername(accountDTO.getUsername());
        model.setPassword(accountDTO.getPassword());
        model.setRole(accountDTO.getRole());
        model.setPhoneNumber(accountDTO.getPhoneNumber());
        model.setBalance(accountDTO.getBalance());

        return accountRepository.save(model);
    }

    @Override
    public Account update(AccountDTO accountDTO, Integer id) {
        Account model = accountRepository.findAccountById(id);
        model.setId(id);
        model.setName(accountDTO.getName());
        model.setUsername(accountDTO.getUsername());
        model.setEmail(accountDTO.getEmail());
        model.setPassword(accountDTO.getPassword());
        model.setRole(accountDTO.getRole());
        model.setPhoneNumber(accountDTO.getPhoneNumber());
        model.setBalance(accountDTO.getBalance());

        return accountRepository.save(model);
    }

    @Override
    public String delete(Integer id) {
        try {
            accountRepository.deleteById(id);
            return "Successfully delete account data!";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete account data!");
        }
    }

    @Override
    public Account getAccountById(Integer id) {
        return accountRepository.findAccountById(id);
    }
}
