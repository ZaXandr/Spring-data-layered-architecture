package com.zakharov.SpringJPA.controller;

import com.zakharov.SpringJPA.dto.DepartureDto;
import com.zakharov.SpringJPA.entity.Departure;
import com.zakharov.SpringJPA.service.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class DepartureController {
    @Autowired
    DepartureService departureService;

//    @GetMapping("/departure/{id}")
//    public Departure departure(@PathVariable int id) {
//        return departureService.getDepartureById(id);
//    }

    @GetMapping("/departure")
    public List<Departure> getDepartures() {
        return departureService.getDepartures();
    }

    @GetMapping("/departure/{name}")
    public ResponseEntity<DepartureDto> getDepartureByName(@PathVariable String name) {
        DepartureDto returnValue = departureService.getDepartureByName(name);

        if (Objects.isNull(returnValue)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(returnValue);
        }
    }

    @PostMapping("/departure")
    public ResponseEntity<Departure> addDeparture(@RequestBody Departure departure) {
        Departure returnValue = departureService.addDeparture(departure);

        if (Objects.isNull(returnValue)) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(returnValue);
        }
    }

    @PutMapping("/departure/{id}")
    public ResponseEntity<Departure> updateDeparture(@RequestBody Departure departure, @PathVariable int id) {
        departure.setId(id);
        Departure returnValue = departureService.updateDeparture(departure);

        if (Objects.isNull(returnValue)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(returnValue);
        }
    }

}
