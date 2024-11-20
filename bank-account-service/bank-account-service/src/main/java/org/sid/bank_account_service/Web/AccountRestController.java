package org.sid.bank_account_service.Web;

import org.sid.bank_account_service.Entities.BankAccount;
import org.sid.bank_account_service.Repository.BankAccountRepository;
import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.sid.bank_account_service.service.AccountService;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;

    private AccountService accountService;


    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
    }


    @GetMapping("/BankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/BankAccounts/{id}")
    public BankAccount getBankAccountById(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));

    }

    @PostMapping("/BankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
        return accountService.addAccount(requestDTO);

    }

    @PutMapping("/BankAccount/{id}")
    public BankAccount Update(@PathVariable String id ,@RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
        if (bankAccount.getBalance() != null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreatedAT() != null) account.setCreatedAT(new Date());
        if (bankAccount.getType() != null) account.setType(bankAccount.getType());
        if (bankAccount.getCurrency() != null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }

     @DeleteMapping("/BankAccount/{id}")
        public void Delete(@PathVariable String id){
          bankAccountRepository.deleteById(id);
        }


}
