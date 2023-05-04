package id.co.bca.spring.ecommerce.account.repository;

import id.co.bca.spring.ecommerce.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountById(Integer id);

    Account findByUsername(String username);
}
