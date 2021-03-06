package com.zakharov.springproject.controller;

import com.zakharov.springproject.dto.WorkerDto;
import com.zakharov.springproject.entity.Worker;
import com.zakharov.springproject.entity.WorkerInfo;
import com.zakharov.springproject.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @GetMapping("/worker")
    public List<Worker> getWorkers() {
        return workerService.getWorkers();
    }

    @GetMapping("/worker/{id}")
    public Worker getWorkerById(@PathVariable int id){
        return workerService.getWorkerById(id);
    }

    @GetMapping("/worker/name/{name}")
    public WorkerDto GetWorkerByName(@PathVariable String name){
        return workerService.getWorkerByName(name);
    }

    @GetMapping("/worker/departure/{id}")
    public List<Worker> getWorkersByDepartureId(@PathVariable int id){
        return workerService.getWorkerByDepartureId(id);
    }

    @PostMapping("/worker")
    public Worker addWorker(@RequestBody Worker worker){
        return workerService.addWorker(worker);
    }

    @PutMapping("/worker")
    public Worker updateWorker(@RequestBody Worker worker){
        return workerService.updateWorker(worker);
    }

    @PutMapping("/workerInfo/{id}")
    public Worker updateWorkerInfo(@RequestBody WorkerInfo workerInfo, @PathVariable int id){
        return workerService.updateWorkerInfo(workerInfo,id);
    }
}
