package com.jpmc.midas.service;

import com.jpmc.midas.model.Transaction;
import com.jpmc.midas.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Service responsible for consuming and processing real-time
 * transaction data from the Kafka cluster.
 */
@Service
public class TransactionListener {

    private static final Logger logger = LoggerFactory.getLogger(TransactionListener.class);
    private final TransactionRepository repository;

    public TransactionListener(TransactionRepository repository) {
        this.repository = repository;
    }

    /**
     * Listens to the 'transactions' topic. 
     * Processes incoming JSON and saves it to the H2 Database.
     */
    @KafkaListener(topics = "transactions", groupId = "midas_group")
    public void consumeTransaction(Transaction transaction) {
        try {
            logger.info("Received Transaction: ID {}", transaction.getId());
            
            // Business logic: e.g., Filter out transactions below a certain threshold
            if (transaction.getAmount() > 0) {
                repository.save(transaction);
                logger.info("Transaction {} successfully persisted to H2 Database.", transaction.getId());
            }
        } catch (Exception e) {
            logger.error("Error processing transaction message: ", e);
        }
    }
}
