package com.moulik.Crimeprediction.controller;

import com.moulik.Crimeprediction.model.CrimeInput;
import com.moulik.Crimeprediction.model.CrimeModel;
import com.moulik.Crimeprediction.service.CrimeFlaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crime")
public class CrimeController {
    @Autowired
    CrimeFlaskService CFS;
    @PostMapping
    public String getCrime(@RequestBody CrimeInput ci){
        double value = CFS.getCrimeData(ci);
        return "The Crime rate is : " + value + "%";
    }
    @GetMapping("/allrecord")
    public ResponseEntity<List<CrimeModel>> getAllRecord(){
        try {
            return new ResponseEntity<>(CFS.getAll(), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/year/{yr}")
    public ResponseEntity<List<CrimeModel>> getAllbyYear(@PathVariable("yr") int yr){
        try {
            return new ResponseEntity<>(CFS.getAllByYear(yr), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/crimerate/{crimeRate}")
    public ResponseEntity<List<CrimeModel>> getAllByCrimeRateLess(@PathVariable("crimeRate") double crimeRate) {
        List<CrimeModel> filtered = CFS.getAllByCrimeRate(crimeRate);
        if (filtered.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(filtered, HttpStatus.OK);
    }

    @GetMapping("/unemployment/{rate}")
    public ResponseEntity<List<CrimeModel>> getAllByUnemploymentRateLess(@PathVariable("rate") double rate) {
        List<CrimeModel> filtered = CFS.getunployrateless(rate);
        if (filtered.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(filtered, HttpStatus.OK);
    }

}
