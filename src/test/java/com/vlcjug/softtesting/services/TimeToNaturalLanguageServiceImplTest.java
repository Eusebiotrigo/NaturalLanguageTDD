package com.vlcjug.softtesting.services;

import com.vlcjug.softtesting.services.impl.TimeToNaturalLanguageServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TimeToNaturalLanguageServiceImplTest {

    @InjectMocks
    private TimeToNaturalLanguageServiceImpl testObj;

    @Mock
    private TimeService timeService;

    @Test
    public void shouldReturnSonLasCuatroWhenCurrentHourIs4() {
        when(timeService.getCurrentTime()).thenReturn(LocalTime.of(16, 30));

        final String result = testObj.convertCurrentTimeToNaturalLanguage();

        assertThat(result).isEqualToIgnoringCase("Son las cuatro");
    }

    @Test
    public void shouldReturnSonLasCincoWhenCurrentHourIs5() {
        when(timeService.getCurrentTime()).thenReturn(LocalTime.of(17, 30));

        final String result = testObj.convertCurrentTimeToNaturalLanguage();

        assertThat(result).isEqualToIgnoringCase("Son las cinco");
    }

    @Test
    public void shouldReturnSonLasNueveWhenCurrentHourIs9() {
        when(timeService.getCurrentTime()).thenReturn(LocalTime.of(9, 30));

        final String result = testObj.convertCurrentTimeToNaturalLanguage();

        assertThat(result).isEqualToIgnoringCase("Son las nueve");

    }

    @Test
    public void shouldReturnEsLaUnaWhenCurrentHourIs13() {
        when(timeService.getCurrentTime()).thenReturn(LocalTime.of(13, 30));

        final String result = testObj.convertCurrentTimeToNaturalLanguage();

        assertThat(result).isEqualToIgnoringCase("Es la una");
    }

    @Test
    public void shouldReturnEsLaUnaWhenCurrentHourIs1() {
        when(timeService.getCurrentTime()).thenReturn(LocalTime.of(1, 30));

        final String result = testObj.convertCurrentTimeToNaturalLanguage();

        assertThat(result).isEqualToIgnoringCase("Es la una");
    }

    @Test
    public void shouldReturnSonLasOnceWhenCurrentHourIs11() {
        when(timeService.getCurrentTime()).thenReturn(LocalTime.of(11, 30));

        final String result = testObj.convertCurrentTimeToNaturalLanguage();

        assertThat(result).isEqualToIgnoringCase("Son las once");
    }

    @Test
    public void shouldReturnSonLasOnceWhenCurrentHourIs23() {
        when(timeService.getCurrentTime()).thenReturn(LocalTime.of(23, 30));

        final String result = testObj.convertCurrentTimeToNaturalLanguage();

        assertThat(result).isEqualToIgnoringCase("Son las once");
    }

    @Test
    public void shouldReturnSonLasDoceWhenCurrentHourIs0() {
        when(timeService.getCurrentTime()).thenReturn(LocalTime.of(0, 30));

        final String result = testObj.convertCurrentTimeToNaturalLanguage();

        assertThat(result).isEqualToIgnoringCase("Son las doce");
    }

    @Test
    public void shouldReturnSonLasDoceWhenCurrentHourIs12() {
        when(timeService.getCurrentTime()).thenReturn(LocalTime.of(12, 30));

        final String result = testObj.convertCurrentTimeToNaturalLanguage();

        assertThat(result).isEqualToIgnoringCase("Son las doce");
    }

}
