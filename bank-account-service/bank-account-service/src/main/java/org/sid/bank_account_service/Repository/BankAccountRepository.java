package org.sid.bank_account_service.Repository;

import org.sid.bank_account_service.Entities.BankAccount;
import org.sid.bank_account_service.Enum.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
   @RestResource(path = "/byType")
   List<BankAccount> findByType(@Param("t") AccountType type);

}
