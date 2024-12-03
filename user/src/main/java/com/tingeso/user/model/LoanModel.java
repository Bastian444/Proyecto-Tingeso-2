package com.tingeso.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanModel {
    private int id;
    private String rut;
    private Date date;
    private float amount;  // Monto del préstamo solicitado
    private String type;   // Tipo de préstamo
    private String state;  // Estado del préstamo
    private double monthlyPayment;
    private double monthlyIncome;
    private double interest;
    private double debtToIncomeRatio;
    private int termMonths;
    private Boolean inDicom;
    private double debtUser;   // Monto de la deuda del usuario
    private int workYears;     // Antigüedad laboral en meses
    private double propertyValue; // Valor total de la propiedad

    // Relacionados con ahorro y depósitos
    private double amountSavingsAcc;  // Saldo en cuenta de ahorros
    private int recentDepositAmount;  // Suma de depósitos en los últimos 12 meses
    private int savingsAccAge;        // Antigüedad de la cuenta de ahorros en meses
    private boolean significantWithdrawal; // Indicador si hubo retiro significativo (últimos 12 meses)
    private double withdrawalAmount;  // Monto del retiro significativo (si aplica)
    private boolean recentWithdrawal; // Indicador si hubo retiro reciente (últimos 6 meses)
    private double recentWithdrawalAmount; // Monto del retiro reciente (si aplica)
    private int rulesAchieved;        // Contador de reglas cumplidas
    private double maxFinancingAmount; // Monto máximo de financiamiento calculado
}
