package com.zakharov.springproject.controller;

import com.zakharov.springproject.entity.WorkerInfo;
import com.zakharov.springproject.service.WorkerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkerInfoController {

    @Autowired
    WorkerInfoService workerInfoService;

    @GetMapping("/workerInfo")
    public List<WorkerInfo> getAllInfo(){
        return workerInfoService.getAllWorkerInfo();
    }

    @PostMapping("/workerInfo")
    public WorkerInfo addWorkerInfo(@RequestBody WorkerInfo workerInfo){
        return workerInfoService.addWorkerInfo(workerInfo);
    }
}
