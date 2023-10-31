package com.belyazid.comptemicroservice.service;

import com.belyazid.comptemicroservice.dto.BankAccountRequestDto;
import com.belyazid.comptemicroservice.dto.BankAccountResponseDto;
import com.belyazid.comptemicroservice.entities.BankAccount;
import org.springframework.stereotype.Service;


public interface AccountService {

    BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto);
    BankAccountResponseDto updateAccount(String id,BankAccountRequestDto bankAccountDto);
    boolean deleteAccount(String id);
}

