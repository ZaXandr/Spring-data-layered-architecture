package com.zakharov.springproject.service;

import com.zakharov.springproject.dto.DepartureDto;
import com.zakharov.springproject.entity.Departure;
import com.zakharov.springproject.entity.Worker;
import com.zakharov.springproject.exception.DepartureNotFoundException;
import com.zakharov.springproject.logger.Logger;
import com.zakharov.springproject.mapper.DepartureMapper;
import com.zakharov.springproject.repository.DepartureRepository;
import com.zakharov.springproject.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartureService {

    private final Logger logger;
    private final DepartureRepository departureRepository;
    private final WorkerRepository workerRepository;
    private final DepartureMapper departureMapper;


    public List<Departure> getDepartures() {
        return departureRepository.findAll();
    }

    public Departure getDepartureById(int id) {
        return departureRepository.findById(id).orElse(null);
    }

    public DepartureDto getDepartureByName(String name) {
        Departure departureByName = departureRepository.findDepartureByName(name);
        DepartureDto departureDto;
        if (!Objects.isNull(departureByName)) {
            List<Worker> workers = workerRepository.findAllByDepartureId(departureByName.getId());

            departureDto = departureMapper.toDto(departureByName)
                    .setWorkersName(workers.stream()
                            .map(Worker::getName)
                            .collect(Collectors.toList()));
        } else {
            throw new DepartureNotFoundException("Departure with name:", name);
        }
        return departureDto;
    }

    public Departure addDeparture(Departure departure) {
        Optional<Departure> departureById = departureRepository.findById(departure.getId());
        if (departureById.isEmpty()) {
            return departureRepository.save(departure);
        } else {
            logger.logMessage(String.format("Departure with id = %d is already exist", departure.getId()));
            return null;
        }
    }

    public Departure updateDeparture(Departure departure) {
        Optional<Departure> departureById = departureRepository.findById(departure.getId());
        if (departureById.isEmpty()) {
            logger.logMessage(String.format("No such departure with id = %d", departure.getId()));
            return null;
        } else {
            return departureRepository.save(departure);
        }
    }
}
