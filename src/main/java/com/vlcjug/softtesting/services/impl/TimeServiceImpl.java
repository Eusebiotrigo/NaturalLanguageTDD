package com.vlcjug.softtesting.services.impl;

import com.vlcjug.softtesting.services.TimeService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class TimeServiceImpl implements TimeService {

    @Override
    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }
}
