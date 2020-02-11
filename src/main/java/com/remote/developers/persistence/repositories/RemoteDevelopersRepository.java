package com.remote.developers.persistence.repositories;

import com.remote.developers.persistence.domain.RemoteDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteDevelopersRepository extends JpaRepository<RemoteDeveloper, Long> {

    @Query("SELECT dev FROM RemoteDeveloper dev where dev.firstName = ?1")
    List<RemoteDeveloper> getAllRemoteDeveloperWithTheSameLastName(String firstName);

    @Query("SELECT dev from RemoteDeveloper dev where lower(dev.firstName) LIKE %:input% or lower(dev.lastName) LIKE %:input%")
    List<RemoteDeveloper> findByTextInput(@Param("input") String input);
}
