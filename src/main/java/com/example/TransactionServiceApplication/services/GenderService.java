package com.example.TransactionServiceApplication.services;

import com.example.TransactionServiceApplication.entities.Gender;
import com.example.TransactionServiceApplication.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {
    private final GenderRepository genderRepository;

    @Autowired
    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public List<Gender> findAll() {
        return genderRepository.findAll();
    }

    public void save(Gender gender) {
        genderRepository.save(gender);
    }
}
