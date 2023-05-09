package com.bernice.onlineCarTrade.Repository;


import com.bernice.onlineCarTrade.Model.carEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface carRepo extends JpaRepository<carEntity,Integer> {
}
