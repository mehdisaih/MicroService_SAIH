package org.sid.bank_account_service.Web;

import org.sid.bank_account_service.Entities.BankAccount;
import org.sid.bank_account_service.Repository.BankAccountRepository;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
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
    public BankAccount save(@RequestBody BankAccount bankAccount){
        if (bankAccount.getId() == null) bankAccount.setId(UUID.randomUUID().toString());
        if (bankAccount.getCreatedAT() == null) bankAccount.setCreatedAT(new Date());
        return bankAccountRepository.save(bankAccount);

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
