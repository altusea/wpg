package com.example.wpg.controller;

import com.example.wpg.model.mo.OperatorMO;
import com.example.wpg.service.OperatorService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operator")
public class OperatorController {

    @Resource
    OperatorService operatorService;

    @PostMapping("/add")
    public void add(@RequestBody OperatorMO user) {
        operatorService.add(user);
    }

    @GetMapping("/listAllId")
    public List<String> listAllId() {
        return operatorService.listAllId();
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") String id) {
        operatorService.deleteById(id);
    }
}
