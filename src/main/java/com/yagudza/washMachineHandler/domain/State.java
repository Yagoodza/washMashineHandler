package com.yagudza.washMachineHandler.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class State {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private WashProgram washProgram;
    @Column(updatable = false)
    private LocalDateTime endTime;
    @Column(nullable = false)
    private boolean isBusy;

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

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }
}
