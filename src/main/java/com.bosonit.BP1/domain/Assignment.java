package com.bosonit.BP1.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Assignment {

    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column
    private String name;
}
