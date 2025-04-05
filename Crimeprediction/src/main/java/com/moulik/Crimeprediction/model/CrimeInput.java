package com.moulik.Crimeprediction.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrimeInput {

    ///    we have match the headers with flask API  thats why we used JsonProperty
    @JsonProperty("Year")
    private int year;

    @JsonProperty("Population")
    private int population;

    @JsonProperty("Unemployment_Rate")
    private double unemploymentRate;

    @JsonProperty("Poverty_Rate")
    private double povertyRate;

    @JsonProperty("Education_Index")
    private double educationIndex;

    public CrimeInput() {}

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getUnemploymentRate() {
        return unemploymentRate;
    }

    public void setUnemploymentRate(double unemploymentRate) {
        this.unemploymentRate = unemploymentRate;
    }

    public double getPovertyRate() {
        return povertyRate;
    }

    public void setPovertyRate(double povertyRate) {
        this.povertyRate = povertyRate;
    }

    public double getEducationIndex() {
        return educationIndex;
    }

    public void setEducationIndex(double educationIndex) {
        this.educationIndex = educationIndex;
    }
}
