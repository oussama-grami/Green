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
@Table( name = "fixed_assests")
public class FixedAssets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "built_area")
    private float builtArea;
    @Column(name = "light_vehicules")
    private int lightVehicule;
    @Column(name = "heavy_vehicules")
    private int heavyVehicule;
    @Column(name = "commercial_vehicules")
    private int commercialVehicule;
    @Column(name = "nb_servers")
    private int nbServers;
    @Column(name = "nb_individual_printers")
    private int nbIndividualPrinter;
    @Column(name = "nb_multifunction_printers")
    private int nbMultifunctionPrinter;
    @Column(name = "nb_panel_screen")
    private int nbPanelScreen;
    @Column(name = "nb_desktops")
    private int nbDesktop;
    @Column(name = "nb_laptops")
    private int nbLaptps;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company campany;
}
