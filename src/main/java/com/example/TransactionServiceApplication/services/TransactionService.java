package com.example.TransactionServiceApplication.services;

import com.example.TransactionServiceApplication.entities.Transaction;
import com.example.TransactionServiceApplication.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public List<Object[]> mostSeenTransactionAbsoluteAmount(int id) {
        return transactionRepository.mostSeenTransactionAbsoluteAmount(id);
    }
    public List<Object[]> getMaxTransaction(int id) {
        return transactionRepository.getMaxTransaction(id);
    }

    public List<Transaction> findByOrderByAmount(){return transactionRepository.findByOrderByAmount();}
    public List<Transaction> findByOrderByAmountDesc(){return transactionRepository.findByOrderByAmountDesc();}

}
