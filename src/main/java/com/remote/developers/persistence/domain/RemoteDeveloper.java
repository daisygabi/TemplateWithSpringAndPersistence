package com.remote.developers.persistence.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "remote_dev")
@Getter
@Setter
public class RemoteDeveloper extends DefaultDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "first_name")
    private String firstName;

    @Column(columnDefinition = "last_name")
    private String lastName;
}

