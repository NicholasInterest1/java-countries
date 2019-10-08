package com.nick.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
//import java.util.Iterator;

@RestController
@RequestMapping("/population")
public class CountryPopulationController {

    @GetMapping(value = "/size/{people}",
    produces = "application/json")
    public ResponseEntity<?> getCountriesByLengthOfName(@PathVariable long people) {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.findCountries(c -> c.getPopulation() >= people) ;
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/min",
    produces = "application/json")
    public ResponseEntity<?> findSmallestPopulation() {
        ArrayList<Country> rtnCountries = (ArrayList) CountriesApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/max",
    produces = "application/json")
    public ResponseEntity<?> findBiggestPopulation() {
        ArrayList<Country> rtnCountries = (ArrayList) CountriesApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/median",
    produces = "application/json")
    public ResponseEntity<?> findTheMedianPopulation() {
        ArrayList<Country> rtnCountries = (ArrayList) CountriesApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
        int medianCountry = (rtnCountries.size()/2);
        return new ResponseEntity<>(rtnCountries.get(medianCountry), HttpStatus.OK);
    }
}
