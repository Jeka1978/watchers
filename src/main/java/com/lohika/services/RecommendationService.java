package com.lohika.services;

import com.lohika.model.RecommendationForSerial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 23/12/2016.
 */
@Service
public class RecommendationService {
    @Autowired
    private WatcherService watcherService;

    public double countInPercents(String serialName){
        RecommendationForSerial recommendations = watcherService.countRecommendations(serialName);
        return 100.0 * (recommendations.getPositiveUsers() / recommendations.getTotalUsers());
    }
}
