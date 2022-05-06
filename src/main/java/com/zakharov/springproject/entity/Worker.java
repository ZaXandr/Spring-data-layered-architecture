package com.zakharov.springproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Worker {

    @Id
    private int id;
    private String name;
    private double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "worker_info")
    WorkerInfo workerInfo;

    @ManyToOne
    @JoinColumn(name = "departure_id", nullable = false)
    private Departure departure;
}
