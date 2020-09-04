package com.yagudza.washMachineHandler.repository;

import com.yagudza.washMachineHandler.domain.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, Long> {
}
