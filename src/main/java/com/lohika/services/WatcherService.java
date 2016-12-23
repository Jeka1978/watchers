package com.lohika.services;

import com.lohika.model.RecommendationForSerial;
import com.lohika.model.Watcher;

/**
 * Created by Evegeny on 23/12/2016.
 */
public interface WatcherService {
    boolean isSerialRecommended(Watcher user, String nameOfTheSerial, int similarity);
    RecommendationForSerial countRecommendations(String nameOfTheSerial);
}
