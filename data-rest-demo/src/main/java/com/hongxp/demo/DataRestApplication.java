package com.hongxp.demo;

import com.hongxp.demo.entity.Customer;
import com.hongxp.demo.repo.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
@Slf4j
public class DataRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataRestApplication.class, args);
    }

    @Bean
    public CommandLineRunner createCustomer(CustomerRepository customerRepository) {
        return (args) -> {
            customerRepository.deleteAll();
            Customer customer;
            for (int i = 0; i < 1000000; i++) {
                customer = new Customer();
                customer.setAge(Long.valueOf(i));
                customer.setName("Customer-" + i);
                customer.setNum(RandomUtils.nextInt(0, 10));
                customerRepository.save(customer);
            }
            /*log.info("Customers found with findAll():");
            log.info("-------------------------------");
            customerRepository.findAll().forEach(System.err::println);

            customerRepository.findByLastName("Bauer")
                    .forEach(bauer -> log.info(bauer.toString()));*/
        };
    }
}
