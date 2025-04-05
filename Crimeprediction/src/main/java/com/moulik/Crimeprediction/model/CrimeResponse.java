package com.moulik.Crimeprediction.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class CrimeResponse {
 ///  we have match the headers with flask API
    @JsonProperty("Predicted_Crime_Rate")
    private double crimeRate;

    public double getCrimeRate() {
        return crimeRate;
    }

    public void setCrimeRate(double crimeRate) {
        this.crimeRate = crimeRate;
    }
}