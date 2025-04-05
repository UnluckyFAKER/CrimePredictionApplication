package com.moulik.Crimeprediction.repo;

import com.moulik.Crimeprediction.model.CrimeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrimeRepo extends JpaRepository<CrimeModel,Integer> {
    List<CrimeModel>findCrimeModelByYear(int year);

    List<CrimeModel> findCrimeModelByUnemploymentRateLessThan(double unemploymentRate);

}
