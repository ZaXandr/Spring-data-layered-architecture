package com.zakharov.SpringJPA.dto;


import com.zakharov.SpringJPA.entity.WorkerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class WorkerDto {
    private int id;
    private String name;
    private double salary;
    private WorkerInfo workerInfo;
}
