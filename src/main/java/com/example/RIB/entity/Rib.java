package com.example.RIB.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Rib {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;




    private String bin;


    private String iban;


    private String address;


    private String tel;
}
