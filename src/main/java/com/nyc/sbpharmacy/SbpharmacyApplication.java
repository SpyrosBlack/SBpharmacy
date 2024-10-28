package com.nyc.sbpharmacy;

import com.nyc.sbpharmacy.model.dto.OrderDto;
import com.nyc.sbpharmacy.model.dto.OrderItemDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.SessionScope;

@SpringBootApplication
public class SbpharmacyApplication {

    public static void main(String[] args) {

        SpringApplication.run(SbpharmacyApplication.class, args);
    }

    @Bean
    @SessionScope
    public OrderDto orderDto() {
        return new OrderDto();
    }

}
