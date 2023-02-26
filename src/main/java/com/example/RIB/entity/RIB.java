package com.example.RIB.entity;

import javax.persistence.*;

@Entity
@Table(name="RIB")
public class RIB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user")
    private String user;

    @Column(name = "bin")
    private String bin;

    @Column(name = "iban")
    private String iban;

    @Column(name = "address")
    private String address;

    @Column(name = "tel")
    private String tel;


}
