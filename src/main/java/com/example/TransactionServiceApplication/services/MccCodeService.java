package com.example.TransactionServiceApplication.services;

import com.example.TransactionServiceApplication.entities.MccCode;
import com.example.TransactionServiceApplication.repositories.MccCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MccCodeService {

    private final MccCodeRepository mccCodeRepository;

    @Autowired
    public MccCodeService(MccCodeRepository mccCodeRepository) {
        this.mccCodeRepository = mccCodeRepository;
    }

    public List<MccCode> findAll() {
        return mccCodeRepository.findAll();
    }

    public void save(MccCode mccCode) {
        mccCodeRepository.save(mccCode);
    }
}
