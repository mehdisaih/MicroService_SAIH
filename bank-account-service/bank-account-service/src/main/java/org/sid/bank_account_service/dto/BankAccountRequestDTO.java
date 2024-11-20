package org.sid.bank_account_service.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bank_account_service.Enum.AccountType;

import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountRequestDTO {

    private Double Balance ;
    private String currency;
    private AccountType type;
}
