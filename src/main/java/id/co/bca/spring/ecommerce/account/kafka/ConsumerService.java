package id.co.bca.spring.ecommerce.account.kafka;

import id.co.bca.spring.ecommerce.account.model.Account;
import id.co.bca.spring.ecommerce.account.repository.AccountRepository;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private NewTopic newTopic;

    public ConsumerService(AccountRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "updateBalance", groupId = "miniproject", containerFactory = "kafkaListenerContainerFactory")
    public void consume(String message) {
        Account account = repository.findAccountById(1);
        account.setBalance(account.getBalance() + Double.parseDouble(message));
        repository.save(account);
        System.out.println("Balance = " + account.getBalance());
    }
}
