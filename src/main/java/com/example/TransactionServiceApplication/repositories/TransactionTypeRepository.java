package com.example.TransactionServiceApplication.repositories;

import com.example.TransactionServiceApplication.entities.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {

}
