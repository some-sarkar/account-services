package com.banking.accountservices.repositories.coreAccountManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.accountservices.models.entities.coreAccountManagement.Account;



@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

   
   Account findByAccountNumber(String accountNumber);
   
}