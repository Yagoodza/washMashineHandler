package com.yagudza.washMachineHandler.service;

import com.yagudza.washMachineHandler.domain.State;
import com.yagudza.washMachineHandler.domain.WashProgram;
import com.yagudza.washMachineHandler.dto.StateDto;
import com.yagudza.washMachineHandler.repository.StateRepository;
import com.yagudza.washMachineHandler.repository.WashProgramRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StateServiceImpl extends DTOConv<State, StateDto> implements StateService {

    private final StateRepository stateRepository;
    private final WashProgramRepository washProgramRepository;
    private final ModelMapper modelMapper;

    public StateServiceImpl(StateRepository stateRepository, WashProgramRepository washProgramRepository, ModelMapper modelMapper) {
        this.stateRepository = stateRepository;
        this.washProgramRepository = washProgramRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StateDto showState() {
        State state = stateRepository.findById(1L).orElse(new State());
        if (state.isBusy()) {
            if (state.getEndTime().isBefore(LocalDateTime.now())) {
                state.setWashProgram(null);
                state.setEndTime(null);
                state.setBusy(false);
                stateRepository.save(state);
            }
        }
        return convertToDto(state);
    }

    @Override
    public StateDto runProgram(long id) {
        State state = stateRepository.findById(1L).orElse(new State());

        if (state.isBusy()) {
            if (state.getEndTime().isBefore(LocalDateTime.now())) {
                stateRepository.deleteAll();
                WashProgram washProgram = washProgramRepository.findById(id).orElseThrow(RuntimeException::new);
                state.setWashProgram(washProgram);
                state.setBusy(true);
                state.setEndTime(LocalDateTime.now().plusMinutes(washProgram.getWorkTime()));
                return convertToDto(stateRepository.save(state));
            }
        }
    return convertToDto(state);
    }

    @Override
    protected StateDto convertToDto(State state) {
        return modelMapper.map(state, StateDto.class);
    }
}