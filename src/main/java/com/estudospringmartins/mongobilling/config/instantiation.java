package com.estudospringmartins.mongobilling.config;

import com.estudospringmartins.mongobilling.Repository.CustomerRepository;
import com.estudospringmartins.mongobilling.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class instantiation implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        customerRepository.deleteAll();

        Customer c1 = new Customer(null, "Léo Pereira", "leo@email.com", "123456789-11");
        Customer c2 = new Customer(null, "Alex Blazer", "alex@email.com", "098764728-12");
        Customer c3 = new Customer(null, "Ramon Branco", "ramon@email.com", "098765432-89");

        customerRepository.saveAll(Arrays.asList(c1,c2,c3));
    }
}
