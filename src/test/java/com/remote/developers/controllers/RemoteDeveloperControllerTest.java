package com.remote.developers.controllers;

import com.remote.developers.persistence.domain.RemoteDeveloper;
import com.remote.developers.persistence.services.dtos.RemoteDeveloperDto;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RemoteDeveloperControllerTest extends BasicRequestTest {

    @Test
    public void create_Developer_With_Valid_Data_ShouldCreate() {
        RemoteDeveloperDto developerDto = new RemoteDeveloperDto();
        developerDto.setFirstName("ME");
        developerDto.setLastName("Test");

        ResponseEntity<RemoteDeveloper> postResponse = getRestTemplate().postForEntity(getRootUrl() + "/developers", developerDto, RemoteDeveloper.class);

        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody().getId());
    }

    @Test
    public void create_Developer_With_InValid_Data_ShouldNotCreate() {
        RemoteDeveloperDto developerDto = null;
        ResponseEntity<RemoteDeveloper> postResponse = getRestTemplate().postForEntity(getRootUrl() + "/developers", developerDto, RemoteDeveloper.class);

        assertEquals(postResponse.getStatusCode(), HttpStatus.BAD_REQUEST);
    }
}