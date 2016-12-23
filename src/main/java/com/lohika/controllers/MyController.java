package com.lohika.controllers;

import com.lohika.model.Watcher;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Evegeny on 23/12/2016.
 */
@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping(value = "/ping")
    public String ping() {
        return "OK!!!!!";
    }


}
