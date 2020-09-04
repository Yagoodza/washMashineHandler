package com.yagudza.washMachineHandler.service;

import com.yagudza.washMachineHandler.domain.State;
import com.yagudza.washMachineHandler.dto.StateDto;
import org.springframework.stereotype.Service;

@Service
public interface StateService {

    StateDto showState();
    StateDto runProgram(long id);

}
