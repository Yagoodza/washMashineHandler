package com.yagudza.washMachineHandler.service;

import com.yagudza.washMachineHandler.dto.WashProgramDto;
import org.springframework.stereotype.Service;

@Service
public interface WashProgramService {

    Iterable<WashProgramDto> findAll();
}
