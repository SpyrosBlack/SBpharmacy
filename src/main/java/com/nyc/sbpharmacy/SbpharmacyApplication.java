package com.nyc.sbpharmacy;

import com.nyc.sbpharmacy.model.dto.OrderDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.annotation.SessionScope;

@SpringBootApplication
public class SbpharmacyApplication {

    public static void main(String[] args) {

        SpringApplication.run(SbpharmacyApplication.class, args);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
