package com.remote.developers.persistence.services;

import com.remote.developers.exceptions.CustomException;
import com.remote.developers.persistence.domain.RemoteDeveloper;
import com.remote.developers.persistence.repositories.RemoteDevelopersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemoteDevelopersService {

    @Autowired
    private RemoteDevelopersRepository remoteDevelopersRepository;

    public RemoteDevelopersService() {}

    public Optional<RemoteDeveloper> findById(Long id) {
        return remoteDevelopersRepository.findById(id);
    }

    public List<RemoteDeveloper> findByTextInput(String input) {
        return remoteDevelopersRepository.findByTextInput(input);
    }

    public List<RemoteDeveloper> getAllRemoteDeveloperWithTheSameLastName(String name) {
        try {
            return remoteDevelopersRepository.getAllRemoteDeveloperWithTheSameLastName(name);
        } catch (Exception e) {
            throw new CustomException("Error retrieving all found developers with the same first name.", HttpStatus.UNPROCESSABLE_ENTITY, e);
        }
    }

    public RemoteDeveloper save(RemoteDeveloper remoteDeveloper) {
        return remoteDevelopersRepository.save(remoteDeveloper);
    }
}
