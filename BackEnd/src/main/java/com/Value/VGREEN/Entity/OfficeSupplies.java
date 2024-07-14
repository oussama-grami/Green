package com.Value.VGREEN.Entity;

import com.Value.VGREEN.Enumeration.Unit;
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
@Table( name = "office_supplies")
public class OfficeSupplies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "paper_expenses")
    private float paperExpences;
    @Column(name = "fourniture_expenses")
    private float fournitureExpences;
    @Enumerated(EnumType.STRING)
    @Column(name = "paper_expenses_unit")
    private Unit unit1;
    @Column(name = "fourniture_expenses_unit")
    @Enumerated(EnumType.STRING)
    private Unit unit2;
    @Column(name = "year")
    private int year;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company campany;
}
