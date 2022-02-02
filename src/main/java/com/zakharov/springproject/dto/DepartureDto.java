package com.zakharov.springproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DepartureDto {

    private int id;
    private String name;
    private String location;
    private List<String> workersName;
}
