package com.paulneville.challenge2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class AccountController {
    private final AccountRepository repository;

    AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account newAccount) {
        log.info("New Account Created {}", newAccount);
        return repository.save(newAccount);
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        List<Account> allAccounts = repository.findAll();
        log.info("Get all accounts {}", allAccounts.size());
        return allAccounts;
    }

    @GetMapping(path = "/accounts/{accountId}")
    public Account getAccountById(@PathVariable("accountId") Long accountId) {
        log.info("Get account by id {}", accountId);
        return repository.findById(accountId)
                .orElseThrow();
    }

    @PutMapping("/accounts/{id}")
    Account replaceAccount(@RequestBody Account newAccount, @PathVariable Long accountId) {
        log.info("Replace account by id {}", accountId);
        return repository.findById(accountId)
                .map(account -> {
                    account.setAccountType(newAccount.getAccountType());
                    account.setAccountNumber(newAccount.getAccountNumber());
                    account.setAccountName(newAccount.getAccountName());
                    account.setBalance(newAccount.getBalance());
                    account.setDate(newAccount.getDate());
                    return repository.save(account);
                })
                .orElseGet(() -> {
                    newAccount.setId(accountId);
                    return repository.save(newAccount);
                });
    }

    @DeleteMapping("/accounts/{id}")
    void deleteAccount(@PathVariable Long accountId) {
        log.info("Delete account by id {}", accountId);
        repository.deleteById(accountId);
    }
}