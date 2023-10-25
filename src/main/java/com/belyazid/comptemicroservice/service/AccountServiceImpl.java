package com.belyazid.comptemicroservice.service;

import com.belyazid.comptemicroservice.dto.BankAccountRequestDto;
import com.belyazid.comptemicroservice.dto.BankAccountResponseDto;
import com.belyazid.comptemicroservice.entities.BankAccount;
import com.belyazid.comptemicroservice.mappers.AccountMapper;
import com.belyazid.comptemicroservice.repository.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {



    BankAccountRepository bankAccountRepository;
    AccountMapper accountMapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDto.getBalance())
                .type(bankAccountDto.getType())
                .currency(bankAccountDto.getCurrency())
                .build () ;
        BankAccount savedaccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDto bankAccountResponseDto = accountMapper.convertToDto(savedaccount);

        return bankAccountResponseDto;
    }
}
