package com.belyazid.comptemicroservice.mappers;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.belyazid.comptemicroservice.dto.BankAccountResponseDto;
import com.belyazid.comptemicroservice.entities.BankAccount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {




    public BankAccountResponseDto convertToDto(BankAccount bankAccount){
        BankAccountResponseDto bankAccountResponseDto =  new BankAccountResponseDto();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDto);
        return bankAccountResponseDto;
    }
}
