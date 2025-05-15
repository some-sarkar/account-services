package com.banking.accountservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.accountservices.models.entities.Account;
import com.banking.accountservices.repositories.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

   

    public Optional<List<Account>> getAllAccounts() {
        return Optional.of(accountRepository.findAll());
    }

    public Optional<Account> getAccountByAccountNumber(String accountNumber) {
        return Optional.of(accountRepository.findByAccountNumber(accountNumber));
        
    }

    public Optional<Account> updateAccountById(Long accountId, Account account) {
        Account existingAccount = accountRepository.findById(accountId)
            .orElseThrow(() -> new RuntimeException("Account not found with ID: " + accountId));
        	
            existingAccount.setAccountNumber(account.getAccountNumber());
            existingAccount.setAccountType(account.getAccountType());
            existingAccount.setAccountStatus(account.getAccountStatus());
            existingAccount.setUserId(account.getUserId());
            existingAccount.setBranchCode(account.getBranchCode());
            existingAccount.setBalance(account.getBalance());
            existingAccount.setNominee(account.getNominee());
        
        return Optional.of(accountRepository.save(existingAccount));

    }

    public Boolean deleteAccountById(Long accountId) {
        if(accountRepository.existsById(accountId)){
            accountRepository.deleteById(accountId);
            return true;
        }
        return false;
    }



    
}
