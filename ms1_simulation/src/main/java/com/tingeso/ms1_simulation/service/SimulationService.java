package com.tingeso.ms1_simulation.service;

import com.tingeso.ms1_simulation.model.SimulationModel;
import com.tingeso.ms1_simulation.controller.SimulationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/*
1 = Positivo
0 = Negativo
 */

@Service
public class SimulationService {

    public int checkIfMonthsTerm(String type, int monthsToPay) {
        // Verifica el tipo de préstamo y el plazo máximo permitido
        switch (type) {
            case "FV": // Primera Vivienda
                if (monthsToPay <= 360) { // 30 años en meses
                    return 1;
                }
                break;
            case "SV": // Segunda Vivienda
                if (monthsToPay <= 240) { // 20 años en meses
                    return 1;
                }
                break;
            case "PC": // Propiedades Comerciales
                if (monthsToPay <= 300) { // 25 años en meses
                    return 1;
                }
                break;
            case "RM": // Remodelación
                if (monthsToPay <= 180) { // 15 años en meses
                    return 1;
                }
                break;
            default:
                // Tipo no válido
                return -1;
        }
        // Si no cumple con las condiciones de plazo máximo
        return 0;
    }

    public int validateLoanAmount(String type, int loanAmount, int propertyValue) {
        // Verifica el monto máximo de financiamiento basado en el tipo de préstamo
        double maxFinancingRatio;
        switch (type) {
            case "FV": // Primera Vivienda
                maxFinancingRatio = 0.80; // 80% del valor de la propiedad
                break;
            case "SV": // Segunda Vivienda
                maxFinancingRatio = 0.70; // 70% del valor de la propiedad
                break;
            case "PC": // Propiedades Comerciales
                maxFinancingRatio = 0.60; // 60% del valor de la propiedad
                break;
            case "RM": // Remodelación
                maxFinancingRatio = 0.50; // 50% del valor de la propiedad actual
                break;
            default:
                // Tipo no válido
                return -1;
        }

        // Calcula el monto máximo permitido
        int maxLoanAmount = (int) (propertyValue * maxFinancingRatio);

        // Retorna 1 si el monto solicitado es válido, 0 si no lo es
        return (loanAmount <= maxLoanAmount) ? 1 : 0;
    }

    // Lógica para validar la tasa de interés
    public int validateInterestRate(String type, double annualInterestRate) {
        double minRate, maxRate;

        switch (type) {
            case "FV": // Primera Vivienda
                minRate = 3.5;
                maxRate = 5.0;
                break;
            case "SV": // Segunda Vivienda
                minRate = 4.0;
                maxRate = 6.0;
                break;
            case "PC": // Propiedades Comerciales
                minRate = 5.0;
                maxRate = 7.0;
                break;
            case "RM": // Remodelación
                minRate = 4.5;
                maxRate = 6.0;
                break;
            default:
                return -1; // Tipo no válido
        }

        // Verifica si la tasa de interés está dentro del rango
        return (annualInterestRate >= minRate && annualInterestRate <= maxRate) ? 1 : 0;
    }

    // Lógica para calcular la cuota mensual
    public double calculateMonthlyPayment(int loanAmount, double annualInterestRate, int monthsToPay) {
        // Convertimos la tasa de interés anual a tasa mensual (r)
        double monthlyRate = annualInterestRate / 12 / 100;

        // Número total de pagos (n)
        int totalPayments = monthsToPay;

        // Si la tasa mensual es 0, significa que es un préstamo sin interés
        if (monthlyRate == 0) {
            return loanAmount / (double) totalPayments;
        }

        // Fórmula de cálculo de la cuota mensual
        double numerator = monthlyRate * Math.pow(1 + monthlyRate, totalPayments);
        double denominator = Math.pow(1 + monthlyRate, totalPayments) - 1;

        return loanAmount * (numerator / denominator);
    }
}
