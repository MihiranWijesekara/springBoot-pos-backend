package com.example.demo.repo;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Iteam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface IteamRepo extends JpaRepository<Iteam, Integer> {
    List<Iteam> findAllByItemNameIs(String itemName);
}

