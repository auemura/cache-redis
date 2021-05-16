package com.example.redis.cache.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.redis.cache.demo.domain.Company;
import com.example.redis.cache.demo.repository.CompanyRepository;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Cacheable(cacheNames = Company.CACHE_NAME, key="#root.method.name")
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Cacheable(cacheNames = Company.CACHE_NAME, key="#identifier")
    public Company findbyIdentifier(final String identifier) {
        return companyRepository.findById(identifier)
                .orElseThrow(() -> new EntityNotFoundException("Identifier not found: " + identifier));
    }

    @CacheEvict(cacheNames = Company.CACHE_NAME, allEntries = true)
    public Company create(final Company company) {
        return companyRepository.save(company);
    }

    @CachePut(cacheNames = Company.CACHE_NAME, key="#company.getIdentifier()")
    public Company update(final Company company) {
        if(company.getIdentifier() == null) {
            throw new EntityNotFoundException("Identifier is empty");
        }

        return companyRepository.save(company);
    }

    @CacheEvict(cacheNames = Company.CACHE_NAME, key="#identifier")
    public void delete(final String identifier) {
        if(identifier == null) {
            throw new EntityNotFoundException("Identifier is empty");
        }

        companyRepository.deleteById(identifier);
    }
}