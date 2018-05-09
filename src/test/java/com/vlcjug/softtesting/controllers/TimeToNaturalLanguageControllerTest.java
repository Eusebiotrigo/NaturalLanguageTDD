package com.vlcjug.softtesting.controllers;

import com.vlcjug.softtesting.services.TimeToNaturalLanguageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TimeToNaturalLanguageControllerTest {

    @InjectMocks
    private TimeToNaturalLanguageController testObj;

    @Mock
    private TimeToNaturalLanguageService timeToNaturalLanguageService;

    @Test
    public void shouldReturnCurrentTimeConvertedToNaturalLanguage() {
        when(timeToNaturalLanguageService.convertCurrentTimeToNaturalLanguage()).thenReturn("Some value containing time in natural language");

        final String result = testObj.getCurrentTime();

        assertTrue(result.equalsIgnoreCase("Some value containing time in natural language"));
    }
}
