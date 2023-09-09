package com.example.wpg.service;

import com.example.wpg.model.mo.OperatorMO;
import com.example.wpg.repo.OperatorRepo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorService {

    @Resource
    private OperatorRepo operatorRepo;

    @Resource
    private CacheService cacheService;

    public void add(OperatorMO operator) {
        cacheService.saveObj("operator", operator);
        operatorRepo.insert(operator);
    }

    public List<String> listAllId() {
        return operatorRepo.listId();
    }

    public OperatorMO getFromCache(String k) {
        return cacheService.get(k);
    }

    public void deleteById(String id) {
        operatorRepo.deleteById(id);
    }
}
