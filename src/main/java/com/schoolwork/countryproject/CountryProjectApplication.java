package com.schoolwork.countryproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryProjectApplication {

    static CountryList myCountryList;
    public static void main(String[] args) {
        myCountryList = new CountryList();

        SpringApplication.run(CountryProjectApplication.class, args);
    }

}
