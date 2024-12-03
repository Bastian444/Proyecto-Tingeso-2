package com.tingeso.loan.service;

import com.tingeso.loan.entity.loanEntity;
import com.tingeso.loan.repository.LoanRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LoanServiceService {

    @Autowired
    private LoanRepositoryService loanRepositoryService;

    @Autowired
    private RestTemplate restTemplate;

    public loanEntity findById(Long id) {
        return loanRepositoryService.findById(id);
    }

    public List<loanEntity> findByRut(String rut) {
        // Busca todos los préstamos asociados al RUT en el repositorio
        return loanRepositoryService.findByRut(rut);
    }

    public List<loanEntity> getAllLoans() {
        // Recupera todos los préstamos desde el repositorio
        return loanRepositoryService.findAll();
    }





}
