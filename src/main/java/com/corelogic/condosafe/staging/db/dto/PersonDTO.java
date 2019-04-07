package com.corelogic.condosafe.staging.db.dto;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class PersonDTO implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;

    protected PersonDTO() {
    }

    public PersonDTO(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return this.name;
    }

    public String getState() {
        return this.state;
    }

}