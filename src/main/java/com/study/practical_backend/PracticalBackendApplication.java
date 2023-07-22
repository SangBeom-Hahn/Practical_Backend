package com.study.practical_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PracticalBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticalBackendApplication.class, args);
    }

}
