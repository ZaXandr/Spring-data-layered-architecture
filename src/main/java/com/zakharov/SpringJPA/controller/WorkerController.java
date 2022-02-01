package com.zakharov.SpringJPA.controller;

import com.zakharov.SpringJPA.entity.Departure;
import com.zakharov.SpringJPA.entity.Worker;
import com.zakharov.SpringJPA.entity.WorkerInfo;
import com.zakharov.SpringJPA.service.WorkerService;
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
    public Worker getWorker(@PathVariable int id){
        return workerService.getWorkerById(id);
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
