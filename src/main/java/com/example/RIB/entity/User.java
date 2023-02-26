package com.example.RIB.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="USER")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;

    private String bin;

    private String iban;

    private String address;

    private String tel;


}
