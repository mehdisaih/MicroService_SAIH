package org.sid.bank_account_service.Repository;

import org.sid.bank_account_service.Entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

}
