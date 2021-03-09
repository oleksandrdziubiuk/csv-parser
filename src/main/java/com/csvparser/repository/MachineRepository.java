package com.csvparser.repository;

import com.csvparser.model.Machine;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MachineRepository extends JpaRepository<Machine, Long> {
    Optional<Machine> getMachineById(Long id);

    @Query("from machines m where m.machineType like :machineType%")
    List<Machine> getMachinesByMachineType(String machineType);
}
