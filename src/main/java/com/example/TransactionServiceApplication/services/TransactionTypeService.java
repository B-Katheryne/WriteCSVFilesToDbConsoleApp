package com.example.TransactionServiceApplication.services;


import com.example.TransactionServiceApplication.entities.TransactionType;
import com.example.TransactionServiceApplication.repositories.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeService {
    private final TransactionTypeRepository typeRepository;

    @Autowired
    public TransactionTypeService(TransactionTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<TransactionType> findAll() {
        return typeRepository.findAll();
    }

    public void save(TransactionType type) {
        typeRepository.save(type);
    }
}
