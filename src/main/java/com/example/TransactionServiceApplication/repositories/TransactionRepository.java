package com.example.TransactionServiceApplication.repositories;

import com.example.TransactionServiceApplication.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query(value = "select abs(amount) as absAm, count(abs(amount)) as v from  transactions where customer_id = :id group by abs(amount) order by v desc limit 1", nativeQuery = true)
    List<Object[]> mostSeenTransactionAbsoluteAmount(@Param("id") int id);
    @Query(value = "select max(amount) from transactions where customer_id = :id", nativeQuery = true)
    List<Object[]> getMaxTransaction(@Param("id") int id);

    List<Transaction> findByOrderByAmount();
    List<Transaction> findByOrderByAmountDesc();
}
