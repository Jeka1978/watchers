package com.lohika.services;

import com.lohika.MockConfig;
import com.lohika.Real;
import com.lohika.model.RecommendationForSerial;
import com.lohika.model.Watcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

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
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MockConfig.class)
public class WatcherServiceImplTest {

    @Autowired
    @Real
    private WatcherService watcherService;

    @Autowired
    private WatcherDao watcherDao;


    @Before
    public void setUp() {
        RestTemplate restTemplate = new RestTemplate();
        Mockito.when(watcherDao.findByName(anyString())).
                thenReturn(Watcher.builder().priority(DRAMA, 80).priority(ACTION, 60).build());

    }

    @Test
    public void countRecommendationsTest() throws Exception {
        RecommendationForSerial recommendationForSerial = watcherService.countRecommendations(GAME_OF_THRONES);
        Assert.assertEquals(3,recommendationForSerial.getTotalUsers());
        Assert.assertEquals(3,recommendationForSerial.getPositiveUsers());
    }

    @Test
    public void testIsRecommended() throws Exception {
        watcherService.isSerialRecommended("jeka",GAME_OF_THRONES,)

    }
}

















