package id.co.bca.spring.ecommerce.account.controller;

import id.co.bca.spring.ecommerce.account.dto.AccountDTO;
import id.co.bca.spring.ecommerce.account.model.Account;
import id.co.bca.spring.ecommerce.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("account")
public class RestAccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("")
    public @ResponseBody Account getAccountById(@RequestParam("id") Integer id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("add")
    public @ResponseBody Object addNewAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.create(accountDTO);
    }

    @PutMapping("update")
    public @ResponseBody Object updateAccount(@RequestBody AccountDTO accountDTO, @RequestParam("id") Integer id) {
        return accountService.update(accountDTO, id);
    }

    @DeleteMapping("delete")
    public @ResponseBody Object deleteCustomer(@RequestParam("id") Integer id) {
        return accountService.delete(id);
    }
}
