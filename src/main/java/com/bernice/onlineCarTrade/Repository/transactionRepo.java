package com.bernice.onlineCarTrade.Repository;

import com.bernice.onlineCarTrade.Model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface transactionRepo extends JpaRepository<TransactionEntity,Integer> {
}
