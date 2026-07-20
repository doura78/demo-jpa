package fr.diginamic;

import jakarta.persistence.*;


@Entity
@Table(name = "regions")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    public Region() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

}
