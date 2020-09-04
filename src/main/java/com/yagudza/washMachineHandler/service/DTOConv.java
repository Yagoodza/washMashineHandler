package com.yagudza.washMachineHandler.service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class DTOConv<S, D> {

    protected abstract D convertToDto(S s);

    protected Iterable<D> convertToDto(Iterable<S> source) {
        return StreamSupport.stream(source.spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
