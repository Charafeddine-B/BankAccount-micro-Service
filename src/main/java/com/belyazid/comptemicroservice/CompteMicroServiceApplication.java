package com.belyazid.comptemicroservice;

import com.belyazid.comptemicroservice.entities.BankAccount;
import com.belyazid.comptemicroservice.enums.AccountType;
import com.belyazid.comptemicroservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class CompteMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteMicroServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository){
        return args -> {
            for (int i = 0; i <10 ; i++) {
                BankAccount bankAccount = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .balance(1000 +Math.random()*9000)
                        .currency("MAD")
                        .createdAt(new Date())
                        .type(Math.random()>0.5 ? AccountType.SAVING_ACCOUNT : AccountType.CURRENT_ACCOUNT)
                        .build();


                bankAccountRepository.save(bankAccount);
            }
        };
    }
}

