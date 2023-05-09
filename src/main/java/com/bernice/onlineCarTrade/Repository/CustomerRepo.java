package com.bernice.onlineCarTrade.Repository;

import com.bernice.onlineCarTrade.Model.carCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<carCustomer,Integer> {
}
