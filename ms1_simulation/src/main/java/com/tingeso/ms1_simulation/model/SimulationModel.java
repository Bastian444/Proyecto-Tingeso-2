package com.tingeso.ms1_simulation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SimulationModel {
    private String type; // Tipo de préstamo
    private int loanAmount; // Monto del préstamo (renombrado de "amount")
    private double annualInterestRate; // Tasa de interés anual (renombrado de "interestRate")
    private int monthsToPay; // Cantidad de meses para pagar el préstamo
    private int propertyValue; // Valor de la propiedad
}
