package org.sid.bank_account_service.service;

import jakarta.transaction.Transactional;
import org.sid.bank_account_service.Entities.BankAccount;
import org.sid.bank_account_service.Repository.BankAccountRepository;
import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.sid.bank_account_service.mapper.Accountmapper;
import org.sid.bank_account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private Accountmapper accountmapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        // Créer une nouvelle entité BankAccount avec les données fournies
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountRequestDTO.getType())
                .Balance(bankAccountRequestDTO.getBalance())
                .CreatedAT(new Date())
                .currency(bankAccountRequestDTO.getCurrency())
                .build();

        // Sauvegarder dans la base de données
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        // Convertir en DTO de réponse à l'aide du mapper
        BankAccountResponseDTO bankAccountResponsetDTO = accountmapper.fromBankAccount(savedBankAccount);

        return bankAccountResponsetDTO;
    }
}
