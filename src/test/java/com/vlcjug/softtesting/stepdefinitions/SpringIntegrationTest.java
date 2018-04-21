package com.vlcjug.softtesting.stepdefinitions;

import com.vlcjug.softtesting.stepdefinitions.helpers.HeaderSettingRequestCallback;
import com.vlcjug.softtesting.stepdefinitions.helpers.ResponseResults;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@Ignore
@ContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringIntegrationTest {

    protected ResponseResults latestResponse = null;

    @LocalServerPort
    private int serverPort;

    protected void executeGet(String url, final String path) {

        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "text/plain");
        final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);

        final TestRestTemplate restTemplate = new TestRestTemplate();

        latestResponse = restTemplate.execute(url + serverPort + path, HttpMethod.GET, requestCallback, ResponseResults::new);
    }
}
