package com.lohika.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Evegeny on 23/12/2016.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Watcher {
    private int id;
    private String name;
    private int age;

    @Singular
    private List<String> favoriteSerials;

    @Singular
    private Map<String,Integer> priorities;

    @SneakyThrows
    public static void main(String[] args) {

        Watcher watcher = Watcher.builder().age(12).id(12).name("Vasya")
                .priority("drama", 70).priority("action", 90).build();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(watcher);
        System.out.println("json = " + json);
        Watcher watcher1 = mapper.readValue(json, Watcher.class);
        System.out.println(watcher1);

    }
}



























