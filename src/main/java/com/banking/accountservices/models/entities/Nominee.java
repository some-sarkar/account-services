package com.banking.accountservices.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "nominees")
public class Nominee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nomineeId;
    private String nomineeName;
    private Long nomineeAadhaarNo;

}
