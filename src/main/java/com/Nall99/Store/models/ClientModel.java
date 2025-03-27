package com.Nall99.Store.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CLIENTS")
public class ClientModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cpf;
    private String name;
    private String email;
    private int age;
    private String status;


}
