package com.vlcjug.softtesting.services.impl;

import com.vlcjug.softtesting.services.TimeService;
import com.vlcjug.softtesting.services.TimeToNaturalLanguageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class TimeToNaturalLanguageServiceImpl implements TimeToNaturalLanguageService {

    @Resource
    private TimeService timeService;

    public String convertCurrentTimeToNaturalLanguage() {

        final LocalTime now = timeService.getCurrentTime();
        final StringBuilder naturalHour = new StringBuilder();

        if (now.getHour() == 1 || now.getHour() == 13) {
            naturalHour.append("Es la");
        } else {
            naturalHour.append("Son las");
        }
        naturalHour.append(" ");

        switch (now.getHour()) {
            case 4:
            case 16:
                naturalHour.append("cuatro");
                break;
            case 1:
            case 13:
                naturalHour.append("una");
                break;
            case 5:
            case 17:
                naturalHour.append("cinco");
                break;
            case 9:
            case 21:
                naturalHour.append("nueve");
                break;
            case 0:
            case 12:
                naturalHour.append("doce");
                break;
            case 11:
            case 23:
                naturalHour.append("once");
                break;
            default:
        }

        return naturalHour.toString();
    }
}
