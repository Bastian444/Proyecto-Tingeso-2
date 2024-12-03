package com.tingeso.loan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private int id;
    private String name;
    private String rut;
    private String category;   // E = Employee, C = Client
    private String email;
    private String password;
    private int age;
    private String sexo;       // M = Masculino, F = Femenino
    private String phoneNumber;
    private String idFront;
    private String idBack;
    private String income;
    private String state = "EV"; // EV = En evaluación, V = Validado, R = Rechazado
}
