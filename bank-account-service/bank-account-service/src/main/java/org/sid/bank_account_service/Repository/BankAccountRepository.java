package org.sid.bank_account_service.Repository;

import org.sid.bank_account_service.Entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {


}
