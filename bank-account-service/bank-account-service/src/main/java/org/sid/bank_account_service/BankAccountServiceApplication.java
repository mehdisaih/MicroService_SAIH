package org.sid.bank_account_service;

import org.sid.bank_account_service.Entities.BankAccount;
import org.sid.bank_account_service.Enum.AccountType;
import org.sid.bank_account_service.Repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository BankAccountRepository) {
		return args -> {

			for (int i = 0; i < 10; i++) {
				BankAccount bankAccount = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.Balance(1000 + Math.random() * 9000)
						.CreatedAT(new Date())
						.currency("MAD")
						.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
						.build();
				BankAccountRepository.save(bankAccount);
			}

		};

	}
}