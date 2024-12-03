package com.tingeso.loan.controller;

import com.tingeso.loan.entity.loanEntity;
import com.tingeso.loan.service.LoanServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanControllerService {

    @Autowired
    LoanServiceService loanServiceService;

    @GetMapping
    public ResponseEntity<List<loanEntity>> getLoans() {
        // Llama al servicio para obtener todos los préstamos
        List<loanEntity> loans = loanServiceService.getAllLoans(); // Corregido: Método existente en el servicio
        if (loans == null || loans.isEmpty())
            return ResponseEntity.noContent().build(); // Devuelve 204 si no hay préstamos
        return ResponseEntity.ok(loans); // Devuelve 200 con la lista de préstamos
    }

    @GetMapping("/{rut}")
    public ResponseEntity<List<loanEntity>> getLoansByRut(@PathVariable("rut") String rut) {
        // Llama al servicio para obtener préstamos por RUT
        List<loanEntity> loans = loanServiceService.findByRut(rut); // Corregido: Variable correcta
        if (loans == null || loans.isEmpty())
            return ResponseEntity.noContent().build(); // Devuelve 204 si no hay préstamos
        return ResponseEntity.ok(loans); // Devuelve 200 con la lista de préstamos
    }
}
