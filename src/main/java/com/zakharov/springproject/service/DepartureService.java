package com.zakharov.springproject.service;

import com.zakharov.springproject.dto.DepartureDto;
import com.zakharov.springproject.entity.Departure;
import com.zakharov.springproject.entity.Worker;
import com.zakharov.springproject.logger.Logger;
import com.zakharov.springproject.repository.DepartureRepository;
import com.zakharov.springproject.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartureService {

    @Autowired
    Logger logger;

    @Autowired
    DepartureRepository departureRepository;

    @Autowired
    WorkerRepository workerRepository;

    public List<Departure> getDepartures() {
        return departureRepository.findAll();
    }

    public Departure getDepartureById(int id) {
        return departureRepository.findById(id).orElse(null);
    }

    public DepartureDto getDepartureByName(String name){
        Departure departureByName = departureRepository.findDepartureByName(name);

        List<Worker> workers = workerRepository.findAllByDepartureId(departureByName.getId());
        DepartureDto departureDto = new DepartureDto()
                .setId(departureByName.getId())
                .setName(departureByName.getName())
                .setLocation(departureByName.getLocation())
                .setWorkersName(workers.stream().map(Worker::getName).collect(Collectors.toList()));

        return departureDto;

    }

    public Departure addDeparture(Departure departure) {
        Optional<Departure> departureById = departureRepository.findById(departure.getId());
        if (departureById.isEmpty()) {
            return departureRepository.save(departure);
        }else {
            logger.logMessage(String.format("Departure with id = %d is already exist",departure.getId()));
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
