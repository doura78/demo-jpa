package fr.diginamic;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;



@Entity
public class Emprunt {
    @Id
    private int id;

    @Column(name = "DATE_DEBUT")
    private String dateDebut;

    @Column(name = "DATE_FIN")
    private String dateFin;

    private int delai;


    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @ManyToMany
    @JoinTable(name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID")
    )
    private List<Livre> livres =  new ArrayList<>();

    public Emprunt() {

    }

    public Emprunt(int id, String dateDebut, String dateFin, int delai) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.delai = delai;
    }

    public int getId() {

        return id;
    }

    public Client client() {
        return client;
    }

    public String getDateDebut() {

        return dateDebut;
    }

    public List<Livre> livres() {
        return livres;
    }

    public String getDateFin() {

        return dateFin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }


    public void setClient(Client client) {
        this.client = client;
    }

    public int getDelai() {

        return delai;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateDebut='" + dateDebut + '\'' +
                ", dateFin='" + dateFin + '\'' +
                ", delai=" + delai +
                ", client=" + client +
                '}';
    }
}
