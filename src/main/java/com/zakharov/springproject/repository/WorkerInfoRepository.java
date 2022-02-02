package com.zakharov.springproject.repository;

import com.zakharov.springproject.entity.WorkerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkerInfoRepository extends JpaRepository<WorkerInfo,Integer> {

    @Query("select w from WorkerInfo as w where w.id = :id")
    WorkerInfo findWorkerInfoById(int id);
}
