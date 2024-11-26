package com.tingeso.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String rut;
    private String category;
    private String email;
    private String password;
    private int age;
    private String sexo;
    private String phoneNumber;
    private String idFront;
    private String idBack;
    private String income;

    @Column(name = "state", nullable = false)
    private String state = "EV"; // Valor predeterminado al crear el usuario
}

/*
    Category:
    - E = Employee
    - C = Client

    State:
    - EV = En evaluación
    - V = Validado
    - R = Rechazado
 */
