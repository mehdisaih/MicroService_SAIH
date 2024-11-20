package org.sid.bank_account_service.service;

import jakarta.transaction.Transactional;
import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        return null;
    }
}
