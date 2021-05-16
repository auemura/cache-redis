package com.example.redis.cache.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.cache.demo.domain.Company;
import com.example.redis.cache.demo.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @GetMapping("/{identifier}")
    public Company findByIdentifier(@PathVariable("identifier") final String identifier) {
        return companyService.findbyIdentifier(identifier);
    }

    @PostMapping
    public Company create(@RequestBody final Company company) {
        return companyService.create(company);
    }

    @PutMapping
    public Company update(@RequestBody final Company company) {
        return companyService.update(company);
    }

    @DeleteMapping("/{identifier}")
    public void delete(@PathVariable("identifier") final String identifier) {
        companyService.delete(identifier);
    }

}
