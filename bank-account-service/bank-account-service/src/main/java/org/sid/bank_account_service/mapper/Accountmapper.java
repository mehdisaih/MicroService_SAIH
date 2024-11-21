package org.sid.bank_account_service.mapper;

import org.sid.bank_account_service.Entities.BankAccount;
import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class Accountmapper {

    // Convertir une entité BankAccount en un DTO de réponse
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponcetDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponcetDTO);
        return bankAccountResponcetDTO;
    }
}
