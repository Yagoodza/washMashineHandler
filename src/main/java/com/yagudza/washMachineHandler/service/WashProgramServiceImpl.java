package com.yagudza.washMachineHandler.service;

import com.yagudza.washMachineHandler.domain.WashProgram;
import com.yagudza.washMachineHandler.dto.WashProgramDto;
import com.yagudza.washMachineHandler.repository.WashProgramRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class WashProgramServiceImpl extends DTOConv<WashProgram, WashProgramDto> implements WashProgramService {

    private final WashProgramRepository washProgramRepository;
    private final ModelMapper modelMapper;

    public WashProgramServiceImpl(WashProgramRepository washProgramRepository, ModelMapper modelMapper) {
        this.washProgramRepository = washProgramRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Iterable<WashProgramDto> findAll() {
        return convertToDto(washProgramRepository.findAll());
    }

    @Override
    protected WashProgramDto convertToDto(WashProgram washProgram) {
        return modelMapper.map(washProgram, WashProgramDto.class);
    }
}

