package com.jpmc.midas.controller;

import com.jpmc.midas.model.Transaction;
import com.jpmc.midas.repository.TransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller to provide an endpoint for external systems 
 * to query transaction data stored in the H2 Database.
 */
@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieves all processed transactions.
     * Accessible via GET: http://localhost:8080/api/v1/transactions
     */
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    /**
     * Retrieves a specific transaction by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable String id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
