package com.yagudza.washMachineHandler.controller;

import com.yagudza.washMachineHandler.dto.WashProgramDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

class WashProgramControllerTest extends AbstractTest {


    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void showAll() throws Exception {
        String uri = "/showAll";
        WashProgramDto washProgramDto = new WashProgramDto();
        washProgramDto.setId(1);
        washProgramDto.setProgram("synthetics");
        washProgramDto.setTemperature(40);
        washProgramDto.setMaxLoad(6);
        washProgramDto.setMaxRPM(1000);
        washProgramDto.setWorkTime(90);
        washProgramDto.setFabricType("cotton");
        washProgramDto.setDescription("description");


        String assertedJson = super.mapToJson(washProgramDto);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();

        WashProgramDto[] washProgramDtos = super.mapFromJson(content, WashProgramDto[].class);
        String returnedJson = super.mapToJson(washProgramDtos[0]);
        assertEquals(assertedJson, returnedJson);
    }
}