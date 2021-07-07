package com.schoolwork.countryproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryPopulationController {
    @GetMapping(value = "/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesWithPopulationAbove(@PathVariable long people){
        ArrayList<Country> rtnCountries = CountryProjectApplication.myCountryList.findCountries(country ->
                country.getPopulation() >= people);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getLowestPopulationCountry(){
        Country rtnCountry = null;
        for (Country country : CountryProjectApplication.myCountryList.countryList){
            if(rtnCountry == null){
                rtnCountry = country;
            }
            if(rtnCountry.getPopulation() > country.getPopulation()){
                rtnCountry = country;
            }
        }
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithGreatestPopulation(){
        Country rtnCountry = null;
        for (Country country : CountryProjectApplication.myCountryList.countryList){
            if(rtnCountry == null){
                rtnCountry = country;
            }
            if(rtnCountry.getPopulation() < country.getPopulation()){
                rtnCountry = country;
            }
        }
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }
}
