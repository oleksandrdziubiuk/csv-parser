package com.csvparser.service;

import com.csvparser.model.Machine;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface MachineService {
    void save(MultipartFile file);

    void update(Machine machine);

    Machine getMachineById(Long id);

    List<Machine> getAll();

    List<Machine> getMachineByType(String machineType);
}
