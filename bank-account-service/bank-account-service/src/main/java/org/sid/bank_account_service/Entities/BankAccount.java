package org.sid.bank_account_service.Entities;

import org.sid.bank_account_service.Enum.AccountType;

import java.util.Date;

public class BankAccount {
    private String id ;
    private Date CreatedAT;
    private double Balance ;
    private String currency;
    private AccountType type;

}
