package com.lohika.services;

import com.lohika.model.RecommendationForSerial;
import com.lohika.model.Watcher;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Evegeny on 23/12/2016.
 */
@Service
public class WatcherServiceImpl implements WatcherService {

    @Autowired
    private WatcherDao watcherDao;

    @Override
    public boolean isSerialRecommended(Watcher user, String nameOfTheSerial, int similarity) {
        return false;
    }

    @Override
    public RecommendationForSerial countRecommendations(String nameOfTheSerial) {
        List<Watcher> watchers = watcherDao.findByFavoriteSerialsContains(nameOfTheSerial);
        long count = watcherDao.count();
        return new RecommendationForSerial(watchers.size(),count);
    }
}
