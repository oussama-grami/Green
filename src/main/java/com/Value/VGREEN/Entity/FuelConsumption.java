package com.Value.VGREEN.Entity;


import com.Value.VGREEN.Enumeration.FuelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table( name = "fuel_Consumption")
public class FuelConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "gasoline")
    private float gasoline;
    @Column(name = "diesel")
    private float diesel;
    @Column(name = "lpg")
    private float lpg;
    @Column(name = "driven_distance")
    private float drivenDistance;
    @Column(name = "fuel_efficiency")
    private float efficiency;
    @Column(name = "fuel_type")
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company campany;
}