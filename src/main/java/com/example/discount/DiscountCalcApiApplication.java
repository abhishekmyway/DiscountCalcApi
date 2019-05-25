package com.example.discount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.discount.pojo.Bill;
import com.example.discount.service.BillDiscountImpl;

@SpringBootApplication
public class DiscountCalcApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscountCalcApiApplication.class, args);
	}
	
	@Bean
    public BillDiscountImpl billDiscountImpl() {
        return new BillDiscountImpl ();
    }
	
	@Bean
    public Bill bill() {
        return new Bill();
    }

}
