package com.lohika.services;

import com.lohika.model.Watcher;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static com.lohika.contsants.Priorities.ACTION;
import static com.lohika.contsants.Priorities.DRAMA;
import static com.lohika.contsants.Serials.GAME_OF_THRONES;
import static com.lohika.contsants.Serials.LOST;
import static com.lohika.contsants.Serials.PRISON_BREAK;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Evegeny on 23/12/2016.
 */
public class WatcherServiceImplTest {
    private List<Watcher> watchers;

    @Before
    public void setUp() {
        watchers = new ArrayList<>();
        watchers.add(Watcher.builder().favoriteSerial(GAME_OF_THRONES).favoriteSerial(LOST).priority(DRAMA, 100).priority(ACTION, 20).build());
        watchers.add(Watcher.builder().favoriteSerial(LOST).favoriteSerial(GAME_OF_THRONES).favoriteSerial(PRISON_BREAK).priority(DRAMA, 90).priority(ACTION, 60).build());
        watchers.add(Watcher.builder().favoriteSerial(LOST).favoriteSerial(GAME_OF_THRONES).priority(DRAMA, 100).priority(ACTION, 20).build());
      /*  when(watcherDao.findByRecommendationsContains(anyString())).thenReturn(watchers);
        when(watcherDao.findAll()).thenReturn(watchers);*/

    }


}