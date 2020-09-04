package com.yagudza.washMachineHandler.controller;

import com.yagudza.washMachineHandler.dto.WashProgramDto;
import com.yagudza.washMachineHandler.service.WashProgramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WashProgramController {

    private final WashProgramService washProgramService;

    public WashProgramController(WashProgramService washProgramService) {
        this.washProgramService = washProgramService;
    }

    @GetMapping("/showAll")
    public ResponseEntity<Iterable<WashProgramDto>> showAll(){
        return ResponseEntity.ok(washProgramService.findAll());
    }
}
