package com.remote.developers.controllers;

import com.remote.developers.TemplateProjectApplication;
import org.flywaydb.core.Flyway;
import org.flywaydb.test.FlywayTestExecutionListener;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base class to be used for entire rest tests suits
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TemplateProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners(listeners = {FlywayTestExecutionListener.class})
@ActiveProfiles("test")
@Transactional
public abstract class BasicRequestTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    Flyway flyway;

    @LocalServerPort
    private String serverPort;

    protected String getRootUrl() {
        return String.format("http://localhost:%s/api/v1", serverPort);
    }

    protected TestRestTemplate getRestTemplate() {
        return restTemplate;
    }

    @Before
    public void prepareDatabase() {
        // Ensure that before each test we have a clean database
        flyway.clean();
        flyway.migrate();
    }

    protected <TBody> HttpEntity<?> buildHTTPEntity(TBody body) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
        return new HttpEntity<TBody>(body, headers);
    }
}
