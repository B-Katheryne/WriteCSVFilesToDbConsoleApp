package com.example.TransactionServiceApplication.repositories;

import com.example.TransactionServiceApplication.entities.Gender;
import com.example.TransactionServiceApplication.entities.MccCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MccCodeRepository extends JpaRepository<MccCode, Integer> {
}
