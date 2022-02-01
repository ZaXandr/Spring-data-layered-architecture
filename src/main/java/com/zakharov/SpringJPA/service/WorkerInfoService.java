package com.zakharov.SpringJPA.service;

import com.zakharov.SpringJPA.entity.WorkerInfo;
import com.zakharov.SpringJPA.repository.WorkerInfoRepository;
import com.zakharov.SpringJPA.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerInfoService {

    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    WorkerInfoRepository workerInfoRepository;

    public List<WorkerInfo> getAllWorkerInfo(){
        return workerInfoRepository.findAll();
    }

    public WorkerInfo addWorkerInfo(WorkerInfo workerInfo) {
        return workerInfoRepository.save(workerInfo);
    }

}
