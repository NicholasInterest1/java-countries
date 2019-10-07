package com.nick.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {

    private static final AtomicLong country = new AtomicLong();
    private long id;
    private String name;
    private long population;
    private int landMass;
    private int medianAge;

    public Country(long id, String name, long population, int landMass, int medianAge) {
        this.id = country.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getLandMass() {
        return landMass;
    }

    public void setLandMass(int landMass) {
        this.landMass = landMass;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }
}
