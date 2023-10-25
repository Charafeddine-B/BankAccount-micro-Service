package com.belyazid.comptemicroservice.web;

import com.belyazid.comptemicroservice.entities.BankAccount;
import com.belyazid.comptemicroservice.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphqlController {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @QueryMapping
    public List<BankAccount> BankAccountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount BankAccountbyId(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
}
