package com.csvparser.controller;

import com.csvparser.model.Machine;
import com.csvparser.service.MachineService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/machines")
public class MachineController {
    private final MachineService machineService;

    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile path) {
        machineService.save(path);
    }

    @GetMapping("/{id}")
    public Machine getById(@PathVariable Long id) {
        return machineService.getMachineById(id);
    }

    @GetMapping("/")
    public List<Machine> getAll() {
        return machineService.getAll();
    }

    @PutMapping("/update/{id}")
    public void updateMachine(@PathVariable Long id, Machine machine) {
        machineService.update(machine);
    }

    @GetMapping("/type{type}")
    public List<Machine> getByType(@PathVariable String type) {
        return machineService.getMachineByType(type);
    }
}
