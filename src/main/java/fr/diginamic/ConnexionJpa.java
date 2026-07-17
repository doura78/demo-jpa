package fr.diginamic;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa");
        EntityManager em = emf.createEntityManager();

        Region r = em.find(Region.class, 1);

        if (r != null) {
            System.out.println("Nom de la région : " + r.getNom());
        } else {
            System.out.println("région inexistante !");
        }
        em.close();
        emf.close();
    }
}
