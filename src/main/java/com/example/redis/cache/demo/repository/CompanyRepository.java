package com.example.redis.cache.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.redis.cache.demo.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {
}