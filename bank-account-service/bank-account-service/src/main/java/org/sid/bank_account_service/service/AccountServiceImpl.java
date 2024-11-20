package org.sid.bank_account_service.service;

import jakarta.transaction.Transactional;
import org.sid.bank_account_service.Entities.BankAccount;
import org.sid.bank_account_service.Repository.BankAccountRepository;
import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountDTO.getType())
                .Balance(bankAccountDTO.getBalance())
                .CreatedAT(new Date())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO = BankAccountResponseDTO.builder()
                .id(savedBankAccount.getId())
                .type(savedBankAccount.getType())
                .Balance(savedBankAccount.getBalance())
                .CreatedAT(savedBankAccount.getCreatedAT())
                .currency(savedBankAccount.getCurrency())
                .build();
        return bankAccountResponseDTO;
    }
}
