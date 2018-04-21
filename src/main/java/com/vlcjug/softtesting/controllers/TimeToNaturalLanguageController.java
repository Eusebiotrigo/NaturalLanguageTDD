package com.vlcjug.softtesting.controllers;

import com.vlcjug.softtesting.services.TimeToNaturalLanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller(value = "/api/time")
public class TimeToNaturalLanguageController {

    @Resource
    private TimeToNaturalLanguageService timeToNaturalLanguageService;

    @GetMapping(produces = "text/plain")
    @ResponseBody
    public String getCurrentTime() {
        return null;
    }
}
