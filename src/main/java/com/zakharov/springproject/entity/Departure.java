package com.zakharov.springproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Departure {

    @Id
    private int id;
    private String name;
    private String location;


}

