package com.cts;

import com.cts.model.Organization;
import com.cts.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class OrganizationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizationServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(OrganizationRepository repository) {
        return args -> {
            Organization organization = Organization.builder()
                                                    .name("cts")
                                                    .contactName("Krishnakumar")
                                                    .contactEmail("n@a.com")
                                                    .contactPhone("78768978678")
                                                    .build();
            repository.save(organization);
            repository.findAll()
                      .forEach(org -> log.info("{}", org));
        };
    }

}
