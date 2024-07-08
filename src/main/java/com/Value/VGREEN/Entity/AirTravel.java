package com.Value.VGREEN.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table( name = "air_travel")
public class AirTravel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "short_air_travel")
    private int shortAirTravel;
    @Column(name = "meduim_air_travel")
    private int meduimAirTravel;
    @Column(name = "long_air_travel")
    private int longAirTravel;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company campany;
}

