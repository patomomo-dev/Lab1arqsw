package com.udea.lab1arq.repository;

import com.udea.lab1arq.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.senderAccountNumber = :acc OR t.receiverAccountNumber = :acc")
    List<Transaction> findByAccountNumber(@Param("acc") String accountNumber);
}