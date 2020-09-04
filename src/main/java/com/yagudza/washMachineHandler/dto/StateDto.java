package com.yagudza.washMachineHandler.dto;

import com.yagudza.washMachineHandler.domain.WashProgram;

import java.time.LocalDateTime;

public class StateDto {

    private long id;
    private WashProgram washProgram;
    private LocalDateTime endTime;
    private Boolean isBusy;

    public Boolean getBusy() {
        return isBusy;
    }

    public void setBusy(Boolean busy) {
        isBusy = busy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WashProgram getWashProgram() {
        return washProgram;
    }

    public void setWashProgram(WashProgram washProgram) {
        this.washProgram = washProgram;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}



