package com.Nall99.Store.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "TB_PRODUCTS")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Float price;
    private String descrition;
    private Integer quant;

    @ManyToOne
    @JsonIgnoreProperties("products")
    private CategoryModel category;

    @ManyToOne
    @JsonIgnoreProperties("products")
    private SupplierModel supplier;

}
