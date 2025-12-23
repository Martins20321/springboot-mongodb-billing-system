package com.estudospringmartins.mongobilling.config;

import com.estudospringmartins.mongobilling.Repository.ChargeRepository;
import com.estudospringmartins.mongobilling.Repository.CustomerRepository;
import com.estudospringmartins.mongobilling.domain.Charge;
import com.estudospringmartins.mongobilling.domain.Customer;
import com.estudospringmartins.mongobilling.domain.enums.ChargeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@Configuration
public class instantiation implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ChargeRepository chargeRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        customerRepository.deleteAll();
        chargeRepository.deleteAll();

        Customer c1 = new Customer(null, "Léo Pereira", "leo@email.com", "123456789-11");
        Customer c2 = new Customer(null, "Alex Blazer", "alex@email.com", "098764728-12");
        Customer c3 = new Customer(null, "Ramon Branco", "ramon@email.com", "098765432-89");

        Charge ch1 = new Charge(null, "Mensalidade Janeiro", sdf.parse("21/03/2022"), 150.00, ChargeStatus.PENDING, c1);
        Charge ch2 = new Charge(null, "Mensalidade Fevereiro", sdf.parse("23/08/2022"), 150.00, ChargeStatus.OVERDUE,c1);
        Charge ch3 = new Charge(null, "IPVA", sdf.parse("29/08/2022"), 3000.00, ChargeStatus.PENDING, c2);
        Charge ch4 = new Charge(null, "Curso Alura", sdf.parse("30/08/2022"), 1500.00, ChargeStatus.PAID,c3);

        customerRepository.saveAll(Arrays.asList(c1,c2,c3));
        chargeRepository.saveAll(Arrays.asList(ch1,ch2,ch3,ch4));
    }
}
