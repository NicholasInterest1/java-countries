package com.nick.countries;

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

    @GetMapping(value = "/all",
    produces = "application/json")
    public ResponseEntity<?> getAllTheCountriesNames() {
        return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/start/{letter}",
    produces = "application/json")
    public ResponseEntity<?> getTheCountriesByFirstLetter(@PathVariable char letter) {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.findCountries(c->c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/size/{number}",
    produces = "aplication/json")
    public ResponseEntity<?> getCountriesByLengthOfName(@PathVariable int number) {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.findCountries(c -> c.getName().length() >= number);
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }
}
