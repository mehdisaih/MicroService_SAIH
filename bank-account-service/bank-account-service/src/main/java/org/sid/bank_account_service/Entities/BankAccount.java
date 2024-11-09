package org.sid.bank_account_service.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bank_account_service.Enum.AccountType;

import java.util.Date;
@Entity@NoArgsConstructor@AllArgsConstructor @Builder@Data
public class BankAccount {
    @Id
    private String id ;
    private Date CreatedAT;
    private Double Balance ;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;

}
