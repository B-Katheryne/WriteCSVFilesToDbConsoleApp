package com.example.TransactionServiceApplication.repositories;

import com.example.TransactionServiceApplication.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer> {

}
