package id.co.bca.spring.ecommerce.account.service;

import id.co.bca.spring.ecommerce.account.model.Account;
import id.co.bca.spring.ecommerce.account.model.MyUserDetail;
import id.co.bca.spring.ecommerce.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException("No Account found!");
        }

        return new MyUserDetail(account);
    }
}