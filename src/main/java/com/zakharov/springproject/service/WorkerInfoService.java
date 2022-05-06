package com.zakharov.springproject.service;

import com.zakharov.springproject.entity.WorkerInfo;
import com.zakharov.springproject.repository.WorkerInfoRepository;
import com.zakharov.springproject.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerInfoService {

    private final WorkerRepository workerRepository;
    private final WorkerInfoRepository workerInfoRepository;

    public List<WorkerInfo> getAllWorkerInfo(){
        return workerInfoRepository.findAll();
    }

    public WorkerInfo addWorkerInfo(WorkerInfo workerInfo) {
        return workerInfoRepository.save(workerInfo);
    }

}
