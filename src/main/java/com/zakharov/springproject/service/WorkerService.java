package com.zakharov.springproject.service;

import com.zakharov.springproject.dto.WorkerDto;
import com.zakharov.springproject.entity.Worker;
import com.zakharov.springproject.entity.WorkerInfo;
import com.zakharov.springproject.logger.Logger;
import com.zakharov.springproject.repository.WorkerInfoRepository;
import com.zakharov.springproject.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    @Autowired
    WorkerInfoRepository workerInfoRepository;

    @Autowired
    Logger logger;

    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }

    public Worker getWorkerById(int id) {
        if (workerRepository.findById(id).isEmpty()) {
            logger.logMessage(String.format("No such worker with id: %s" , id));
            return null;
        }else {
            return workerRepository.getById(id);
        }
    }

    public List<Worker> getWorkerByDepartureId(@PathVariable int id) {
        return workerRepository.findAllByDepartureId(id);
    }

    public Worker addWorker(Worker worker) {
        Optional<Worker> departureById = workerRepository.findById(worker.getId());
        if (departureById.isEmpty()) {
            return workerRepository.save(worker);
        } else {
            logger.logMessage(String.format("Worker with id = %d is already exist", worker.getId()));
            return null;
        }
    }

    public WorkerDto getWorkerByName(String name) {
        Worker worker = workerRepository.findByName(name);
        WorkerInfo info = workerInfoRepository.findWorkerInfoById(worker.getId());

        WorkerDto workerDto = new WorkerDto()
                .setId(worker.getId())
                .setName(worker.getName())
                .setSalary(worker.getSalary())
                .setWorkerInfo(info);
        return workerDto;
    }


    public Worker updateWorker(Worker worker) {
        Optional<Worker> w = workerRepository.findById(worker.getId());
        if (w.isEmpty()) {
            logger.logMessage(String.format("No such worker with id: %d", worker.getId()));
            return null;
        } else {
            return workerRepository.save(worker);
        }
    }

    public Worker updateWorkerInfo(WorkerInfo workerInfo, int id) {
        Worker worker = workerRepository.getById(id);
        if (Objects.isNull(worker)) {
            logger.logMessage(String.format("No such worker with id: %d", id));
            return null;
        } else {
            worker.setWorkerInfo(workerInfo);
            return workerRepository.save(worker);
        }
    }

}
