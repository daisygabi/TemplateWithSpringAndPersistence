package com.remote.developers.persistence.services;

import com.remote.developers.persistence.domain.RemoteDeveloper;
import com.remote.developers.persistence.repositories.RemoteDevelopersRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class RemoteDevelopersServiceTest {

    @TestConfiguration
    static class EventServiceConfiguration {

        @Bean
        public RemoteDevelopersService remoteDevelopersService() {
            return new RemoteDevelopersService();
        }
    }

    @Autowired
    private RemoteDevelopersService remoteDevelopersService;

    @MockBean
    private RemoteDevelopersRepository repository;
    private RemoteDeveloper developer;

    @Before
    public void setUp() {
        developer = new RemoteDeveloper();
        developer.setCreatedAt(new Date());
        developer.setId(1L);
        developer.setFirstName("Gabi");
        developer.setLastName("Test");

        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.ofNullable(developer));
        Mockito.when(repository.findByTextInput("Gabi")).thenReturn(Collections.singletonList(developer));
        Mockito.when(repository.save(developer)).thenReturn(developer);
    }

    @Test
    public void findById_WithValidData_ShouldReturnDeveloper() {
        Optional<RemoteDeveloper> foundDeveloper = remoteDevelopersService.findById(1L);

        assertThat(foundDeveloper.get().getFirstName()).isEqualTo(developer.getFirstName());
        assertThat(foundDeveloper.get().getLastName()).isEqualTo(developer.getLastName());
    }

    @Test
    public void findById_WithInValidData_ShouldReturnNothing() {
        Optional<RemoteDeveloper> foundDeveloper = remoteDevelopersService.findById(100L);

        assertThat(foundDeveloper).isEmpty();
    }

    @Test
    public void saveDeveloper_WithValidData_ShouldCreateNewDeveloperEntry() {
        RemoteDeveloper savedDeveloper = remoteDevelopersService.save(developer);

        assertThat(savedDeveloper.getFirstName()).isEqualTo(savedDeveloper.getFirstName());
        assertThat(savedDeveloper.getLastName()).isEqualTo(savedDeveloper.getLastName());
    }

    @Test()
    public void saveDeveloper_WithInValidData_ShouldCreateNewDeveloperEntry() {
        RemoteDeveloper savedDeveloper = remoteDevelopersService.save(null);

        assertThat(savedDeveloper).isNull();
    }
}