package com.Nall99.Store.models;

import jakarta.persistence.*;


@Entity
@Table(name = "TB_EMPLOYEES")
public class EmployeeModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int idade;
    private String cpf;
    private String email;
    private float salary;
}
