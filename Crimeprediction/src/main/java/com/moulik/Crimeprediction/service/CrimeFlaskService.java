package com.moulik.Crimeprediction.service;

import com.moulik.Crimeprediction.config.RestConfig;
import com.moulik.Crimeprediction.model.CrimeInput;
import com.moulik.Crimeprediction.model.CrimeModel;
import com.moulik.Crimeprediction.model.CrimeResponse;
import com.moulik.Crimeprediction.repo.CrimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrimeFlaskService {

    @Autowired
    private CrimeRepo CR;
    private final RestTemplate restTemplate;

    public CrimeFlaskService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public double getCrimeData(CrimeInput input){
        String flaskUrl = "http://localhost:5000/predict";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CrimeInput> inputEntity = new HttpEntity<>(input,headers);
        ResponseEntity<CrimeResponse> RE = restTemplate.postForEntity(flaskUrl,inputEntity,CrimeResponse.class);
        double cr7= RE.getBody().getCrimeRate();
        ///  now save to db
        CrimeModel model= new CrimeModel();
        model.setYear(input.getYear());
        model.setPopulation(input.getPopulation());
        model.setEducationIndex(input.getEducationIndex());
        model.setPovertyRate(input.getPovertyRate());
        model.setUnemploymentRate(input.getUnemploymentRate());
        model.setCrimeRate(cr7);
        CR.save(model);
        return cr7;


    }
    public List<CrimeModel> getAll(){
        return CR.findAll();
    }
    public List<CrimeModel> getAllByYear(int year){
        return CR.findCrimeModelByYear(year);
    }
   // custom method
    public List<CrimeModel> getAllByCrimeRate(double value) {
        List<CrimeModel> CM = CR.findAll();
        return CM.stream()
                .filter(x -> x.getCrimeRate() < value)
                .collect(Collectors.toUnmodifiableList());
    }

    //  uses a Spring Data JPA derived query
    public List<CrimeModel> getunployrateless(double value) {
        return CR.findCrimeModelByUnemploymentRateLessThan(value);
    }



}
