package com.lohika.services;

import com.lohika.model.Watcher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Evegeny on 23/12/2016.
 */
public interface WatcherDao extends MongoRepository<Watcher,Integer>{
    Watcher findByName(@Param("name") String name);
}
