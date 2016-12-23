package com.lohika.controllers;

import com.lohika.model.Watcher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.lohika.contsants.Priorities.ACTION;
import static com.lohika.contsants.Priorities.DRAMA;
import static com.lohika.contsants.Serials.GAME_OF_THRONES;
import static com.lohika.contsants.Serials.PRISON_BREAK;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Evegeny on 23/12/2016.
 */
public class WatcherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void countUsersWhichRecommends() throws Exception {
//        when(watcherDao.count()).thenReturn((long) watchers.size());
        mockMvc.perform(
                get("/users/recommendation/count/serial/" + GAME_OF_THRONES)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.possitiveUsers", equalTo(3)))
                .andExpect(jsonPath("$.totalUsers", equalTo(3)));


    }

    @Test
    public void isRecommended() throws Exception {
 /*       Watcher watcher = Watcher.builder().priority(DRAMA, 80).priority(ACTION, 60).build();
        when(watcherDao.findByName(anyString())).thenReturn(watcher);*/
        mockMvc.perform(
                get("/watchers/recommendation//serial/" + GAME_OF_THRONES + "/66/jeka")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));
        mockMvc.perform(
                get("/watchers/recommendation//serial/" + PRISON_BREAK + "/66/jeka"))
                .andExpect(content().string(containsString("false")));

        mockMvc.perform(
                get("/watchers/recommendation//serial/" + PRISON_BREAK + "/75/jeka"))
                .andExpect(content().string(containsString("true")));

    }

}