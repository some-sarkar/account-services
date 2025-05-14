package com.banking.accountservices.controllers.coreAccountManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banking.accountservices.models.entities.coreAccountManagement.Account;
import com.banking.accountservices.services.coreAccoutManagement.AccountService;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/get-all-accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts().orElse(null), HttpStatus.OK);
    }

    @GetMapping("/get-all-accounts/{accountNumber}")
    public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable String accountNumber) {
        return new ResponseEntity<>(accountService.getAccountByAccountNumber(accountNumber).orElse(null),
                HttpStatus.OK);
    }

    @PostMapping("/add-account")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    @PutMapping("/update-account/{accountId}")
    public ResponseEntity<Account> updateAccountById(@PathVariable Long accountId, @RequestBody Account account) {
        return new ResponseEntity<>(accountService.updateAccountById(accountId, account).orElse(null),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-account/{accountId}")
    public ResponseEntity<String> deleteAccountById(@PathVariable Long accountId){
        Boolean ifDeleted = accountService.deleteAccountById(accountId);
        if(ifDeleted)
            return new ResponseEntity<>("Successfully Deleted...", HttpStatus.OK);
        else    
            return new ResponseEntity<>("Account not found...", HttpStatus.NOT_FOUND);
    }

}
