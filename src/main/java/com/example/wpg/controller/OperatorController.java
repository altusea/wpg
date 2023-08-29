package com.example.wpg.controller;

import com.example.wpg.model.OperatorMO;
import com.example.wpg.service.OperatorService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
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
}
