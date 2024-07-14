package com.Value.VGREEN.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table( name = "Energy")
public class Energy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nb_employee")
    private int nbEmployee;
    @Column(name = "telework_pourcentage")
    private float teleworkPourcentage;
    @Column(name = "electricity")
    private float electricity;
    @Column(name = "propane")
    private float propane;
    @Column(name = "natural_gaz")
    private float gaz;
    @Column(name = "fuel")
    private float fuel;
    @Column(name = "coal")
    private float coal;
    @Column(name = "refrigerant")
    private float refregerant;
    @Column(name = "lpg")
    private float lpg;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company campany;
}
