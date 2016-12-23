package com.lohika.services;

import com.lohika.model.RecommendationForSerial;
import com.lohika.model.Watcher;
import lombok.Setter;

/**
 * Created by Evegeny on 23/12/2016.
 */
@Setter
public class WatcherServiceImpl implements WatcherService {

    private WatcherDao watcherDao;
    @Override
    public boolean isSerialRecommended(Watcher user, String nameOfTheSerial, int similarity) {
        return false;
    }

    @Override
    public RecommendationForSerial countRecommendations(String nameOfTheSerial) {
        return null;
    }
}
