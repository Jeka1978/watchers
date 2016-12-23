package com.lohika;

import com.lohika.model.RecommendationForSerial;
import com.lohika.model.Watcher;
import com.lohika.services.RecommendationService;
import com.lohika.services.WatcherDao;
import com.lohika.services.WatcherService;
import com.lohika.services.WatcherServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

import static com.lohika.contsants.Priorities.ACTION;
import static com.lohika.contsants.Priorities.DRAMA;
import static com.lohika.contsants.Serials.GAME_OF_THRONES;
import static com.lohika.contsants.Serials.LOST;
import static com.lohika.contsants.Serials.PRISON_BREAK;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Evegeny on 23/12/2016.
 */
@Configuration
public class MockConfig {

    //**************************** MOCK BEANS ******************************

    @Bean
    @Primary
    public WatcherDao watcherDaoMock() {
        List<Watcher> watchers = new ArrayList<>();
        WatcherDao watcherDao = Mockito.mock(WatcherDao.class);
        watchers = new ArrayList<>();
        watchers.add(Watcher.builder().favoriteSerial(GAME_OF_THRONES).favoriteSerial(LOST).priority(DRAMA, 100).priority(ACTION, 20).build());
        watchers.add(Watcher.builder().favoriteSerial(LOST).favoriteSerial(GAME_OF_THRONES).favoriteSerial(PRISON_BREAK).priority(DRAMA, 90).priority(ACTION, 60).build());
        watchers.add(Watcher.builder().favoriteSerial(LOST).favoriteSerial(GAME_OF_THRONES).priority(DRAMA, 100).priority(ACTION, 20).build());
        when(watcherDao.findAll()).thenReturn(watchers);
        when(watcherDao.count()).thenReturn(3L);
        when(watcherDao.findByFavoriteSerialsContains(anyString())).thenReturn(watchers);
        return watcherDao;
    }


    @Bean
    @Primary
    public WatcherService watcherServiceMock() {
        WatcherService mock = Mockito.mock(WatcherService.class);
        Mockito.when(mock.countRecommendations(anyString())).thenReturn(new RecommendationForSerial(10, 100));
        return mock;
    }

    //**************************** REAL BEANS ******************************


    @Bean
    @Real
    public WatcherService watcherServiceReal() {
        return new WatcherServiceImpl();
    }

    @Bean
    @Real
    public RecommendationService recommendationServiceReal() {
        return new RecommendationService();
    }


}
