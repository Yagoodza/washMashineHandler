package com.yagudza.washMachineHandler.controller;

import com.yagudza.washMachineHandler.dto.StateDto;
import com.yagudza.washMachineHandler.service.StateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/showState")
    public ResponseEntity<StateDto> showState() {
            return ResponseEntity.ok(stateService.showState());
    }

    @GetMapping("/startProgram/{id}")
    public ResponseEntity<StateDto> startProgram(@PathVariable("id") long id){
        return ResponseEntity.ok(stateService.runProgram(id));
    }
}
