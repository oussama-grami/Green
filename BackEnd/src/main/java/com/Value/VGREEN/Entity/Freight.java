package com.Value.VGREEN.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.RowId;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table( name = "freight")
public class Freight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "small_air_freight")
    private float smallAirFreight;
    @Column(name = "big_air_freight")
    private float bigAirFreight;
    @Column(name = "big_sea_freight")
    private float bigSeaFreight;
    @Column(name = "small_sea_freight")
    private float smallSeaFreight;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company campany;


}
