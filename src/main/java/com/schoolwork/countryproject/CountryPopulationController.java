package com.schoolwork.countryproject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController("/population")
public class CountryPopulationController {
    @GetMapping(value = "/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesWithPopulationAbove(@PathVariable long people){

    }

    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getLowestPopulationCountry(){

    }

    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithGreatestPopulation(){

    }
}
