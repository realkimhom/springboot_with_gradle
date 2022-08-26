package com.example.demo.service;

import com.example.demo.beans.WikiAuction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WARepository extends JpaRepository<WikiAuction, Integer> {

}
