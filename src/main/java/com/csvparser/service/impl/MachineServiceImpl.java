package com.csvparser.service.impl;

import com.csvparser.exception.DataProcessingException;
import com.csvparser.model.Machine;
import com.csvparser.repository.MachineRepository;
import com.csvparser.service.MachineService;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MachineServiceImpl implements MachineService {
    private final MachineRepository machineRepository;

    public MachineServiceImpl(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Override
    public void save(MultipartFile file) {
        CsvReader csvReader = new CsvReader();
        List<Machine> machines = null;
        try {
            machines = csvReader.csvMachines(file.getInputStream());
        } catch (IOException e) {
            throw new DataProcessingException("Can't save data from csv", e);
        }
        machineRepository.saveAll(machines);
    }

    @Override
    public void update(Machine machine) {
        machineRepository.save(machine);
    }

    @Override
    public Machine getMachineById(Long id) {
        return machineRepository.findById(id).orElseThrow(
                () -> new DataProcessingException("Can't get data from machine by id " + id));
    }

    @Override
    public List<Machine> getAll() {
        return machineRepository.findAll();
    }

    @Override
    public List<Machine> getMachineByType(String machineType) {
        return machineRepository.getMachinesByMachineType(machineType);
    }
}
