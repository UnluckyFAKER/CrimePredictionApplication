package com.moulik.Crimeprediction.model;

import jakarta.persistence.*;

@Entity
@Table(name = "crime_data")
public class CrimeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private int year;
    private long population;
    private  double unemploymentRate;
    private  double povertyRate;
    private double educationIndex;
    private double crimeRate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
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

    public double getCrimeRate() {
        return crimeRate;
    }

    public void setCrimeRate(double crimeRate) {
        this.crimeRate = crimeRate;
    }
   public CrimeModel(int year,long population,double unemploymentRate,double povertyRate,double educationIndex, double crimeRate){
        this.year=year;
        this.population=population;
        this.educationIndex=educationIndex;
        this.unemploymentRate=unemploymentRate;
        this.povertyRate=povertyRate;
        this.crimeRate=crimeRate;
    }
    public CrimeModel(){

    }

}
