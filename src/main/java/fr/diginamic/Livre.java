package fr.diginamic;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;



@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String auteur;

    @ManyToMany
    @JoinTable(name = "COMPO",
        joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID")
    )
            private List<Emprunt> emprunts = new ArrayList<>();

    public Livre() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }


    public Livre(int id, String titre, String auteur) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                '}';
    }
}
