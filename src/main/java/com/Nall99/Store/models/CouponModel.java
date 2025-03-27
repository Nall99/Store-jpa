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
@Table(name = "TB_COUPONS")
public class CouponModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String cod;
    private float discount;
    private String discount_type;
    private String status;
    private int usos_maximos;
    

}
