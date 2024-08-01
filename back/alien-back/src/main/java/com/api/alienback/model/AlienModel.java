package com.api.alienback.model;

import com.api.alienback.DTOs.AlienDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "ALIENMODEL")
@Table(name = "ALIEN")
@NoArgsConstructor
public class AlienModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private BigDecimal id;

    @Getter @Setter
    @Column(name = "name",nullable = false)
    private String name;

    @Getter @Setter
    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Getter @Setter
    @Column(name = "password",nullable = false)
    private String password;

    public AlienModel(AlienDTO alienDTO){
        this.name = alienDTO.name().toUpperCase();
        this.email = alienDTO.email().toUpperCase();
        this.password = alienDTO.password().toUpperCase();
    }

}
