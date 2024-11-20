package org.sid.bank_account_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bank_account_service.Enum.AccountType;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountResponseDTO {

    private String id ;
    private Date CreatedAT;
    private Double Balance ;
    private String currency;
    private AccountType type;
}
