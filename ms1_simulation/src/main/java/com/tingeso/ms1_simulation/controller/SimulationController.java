package com.tingeso.ms1_simulation.controller;

import com.tingeso.ms1_simulation.service.SimulationService;
import com.tingeso.ms1_simulation.model.SimulationModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/loan/simulation")
public class SimulationController {

    @Autowired
    SimulationService simulationService;

    // Endpoint para calcular la simulación completa
    @PostMapping
    public ResponseEntity<Double> simulation(@RequestBody SimulationModel simulationModel) {
        // Valida los términos del plazo
        int termValidation = simulationService.checkIfMonthsTerm(
                simulationModel.getType(),
                simulationModel.getMonthsToPay()
        );

        if (termValidation != 1) {
            return ResponseEntity.badRequest().body(null);
        }

        // Valida el monto del préstamo
        int amountValidation = simulationService.validateLoanAmount(
                simulationModel.getType(),
                simulationModel.getLoanAmount(),
                simulationModel.getPropertyValue()
        );

        if (amountValidation != 1) {
            return ResponseEntity.badRequest().body(null);
        }

        // Valida la tasa de interés
        int rateValidation = simulationService.validateInterestRate(
                simulationModel.getType(),
                simulationModel.getAnnualInterestRate()
        );

        if (rateValidation != 1) {
            return ResponseEntity.badRequest().body(null);
        }

        // Calcula la cuota mensual
        double monthlyPayment = simulationService.calculateMonthlyPayment(
                simulationModel.getLoanAmount(),
                simulationModel.getAnnualInterestRate(),
                simulationModel.getMonthsToPay()
        );

        return ResponseEntity.ok(monthlyPayment);
    }

    // Endpoint para validar términos de plazo
    @GetMapping("/validate-term")
    public ResponseEntity<Integer> validateTerm(
            @RequestParam String type,
            @RequestParam int monthsToPay) {
        int result = simulationService.checkIfMonthsTerm(type, monthsToPay);
        return ResponseEntity.ok(result);
    }

    // Endpoint para validar monto del préstamo
    @GetMapping("/validate-amount")
    public ResponseEntity<Integer> validateAmount(
            @RequestParam String type,
            @RequestParam int loanAmount,
            @RequestParam int propertyValue) {
        int result = simulationService.validateLoanAmount(type, loanAmount, propertyValue);
        return ResponseEntity.ok(result);
    }

    // Endpoint para validar tasa de interés
    @GetMapping("/validate-rate")
    public ResponseEntity<Integer> validateRate(
            @RequestParam String type,
            @RequestParam double annualInterestRate) {
        int result = simulationService.validateInterestRate(type, annualInterestRate);
        return ResponseEntity.ok(result);
    }

    // Endpoint para calcular cuota mensual
    @GetMapping("/calculate-payment")
    public ResponseEntity<Double> calculatePayment(
            @RequestParam int loanAmount,
            @RequestParam double annualInterestRate,
            @RequestParam int monthsToPay) {
        double result = simulationService.calculateMonthlyPayment(loanAmount, annualInterestRate, monthsToPay);
        return ResponseEntity.ok(result);
    }




}
