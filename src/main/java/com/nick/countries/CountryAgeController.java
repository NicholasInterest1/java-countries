package com.nick.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class CountryAgeController {

    @GetMapping(value = "/age/{age}",
    produces = "application/json")
    public ResponseEntity<?> getCountriesByMedianAge(@PathVariable int age) {
        ArrayList<Country> rtnCountries = new ArrayList<>();
        rtnCountries = CountriesApplication.ourCountryList.findCountries(c->c.getMedianAge() >= age);
        rtnCountries.sort((c1, c2) -> c2.getMedianAge() - c1.getMedianAge());
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/min",
    produces = "application/json")
    public ResponseEntity<?> getSmallestMedianAge() {
        ArrayList<Country> rtnCountries = (ArrayList) CountriesApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> c1.getMedianAge() - c2.getMedianAge());
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/max",
    produces = "application/json")
    public ResponseEntity<?> getBiggestMedianAge() {
        ArrayList<Country> rtnCountries = (ArrayList) CountriesApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> c2.getMedianAge() - c1.getMedianAge());
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/median",
    produces = "application/json")
    public ResponseEntity<?> getMedianMedianAge() {
        ArrayList<Country> rtnCountries = (ArrayList) CountriesApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> c2.getMedianAge() - c1.getMedianAge());
        int medianCountry = rtnCountries.size() /2;
        return new ResponseEntity<>(rtnCountries.get(medianCountry), HttpStatus.OK);
    }
}
