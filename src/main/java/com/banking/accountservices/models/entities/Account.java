package com.banking.accountservices.models.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "accounts")
public class Account {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    private String accountNumber;
    private String accountType;
    private String accountStatus;
    private Long userId;
    private String branchCode;
    private String ifscCode;
    private Long balance;
    private Long nomineeId;
    
    
}
