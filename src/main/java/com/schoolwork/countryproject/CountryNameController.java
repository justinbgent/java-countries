package com.schoolwork.countryproject;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryNameController {

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {
        CountryProjectApplication.myCountryList.countryList.sort(((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName())));
        return new ResponseEntity<>(CountryProjectApplication.myCountryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesStartingWith(@PathVariable char letter){
//        CountryTester countryTester = new CountryTester() {
//            @Override
//            public boolean testCountry(Country country) {
//                return country.getName().toLowerCase().charAt(0) == Character.toLowerCase(letter);
//            }
//        };
//        ArrayList<Country> rtnCountries = CountryProjectApplication.myCountryList.findCountries(countryTester);
        //These two lines below are equivalent to the commented lines above
        ArrayList<Country> rtnCountries = CountryProjectApplication.myCountryList.findCountries(country ->
                country.getName().toLowerCase().charAt(0) == Character.toLowerCase(letter));
        rtnCountries.sort((c1, c2) -> (c1.getName().compareToIgnoreCase(c2.getName())));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/size/{number}")
    public ResponseEntity<?> getCountryNamesEqualOrLonger(@PathVariable int number){
        ArrayList<Country> rtnCountries = CountryProjectApplication.myCountryList.findCountries(country ->
                country.getName().length() >= number);
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

}
