package com.zakharov.springproject.mapper;

import com.zakharov.springproject.dto.DepartureDto;
import com.zakharov.springproject.entity.Departure;
import org.springframework.stereotype.Component;

@Component
public class DepartureMapper {

    public DepartureDto toDto(Departure departure) {
        DepartureDto departureDto = new DepartureDto()
                .setName(departure.getName())
                .setId(departure.getId())
                .setLocation(departure.getLocation());
        return departureDto;
    }

    public Departure toModel(DepartureDto dto) {
        Departure departure = new Departure()
                .setId(dto.getId())
                .setName(dto.getName())
                .setLocation(dto.getLocation());
        return departure;
    }

}
