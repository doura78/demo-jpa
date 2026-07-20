package fr.diginamic;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ConnexionJpa {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa");
        EntityManager em = emf.createEntityManager();


        Livre l1 = em.find(Livre.class, 1);
        if (l1 != null) {
            System.out.println(l1.getId());
        } else {
            System.out.println("Le livre " + l1.getId() + " est déja emprunté");
        }

        Livre l2 = em.find(Livre.class, 2);
        if(l2 != null) {
            System.out.println(l2.getNom());
        } else {
            System.out.println("Le livre " + l2.getId() + " est déja emprunté");
        }

        Livre l3 = em.find(Livre.class, 3);
        if (l3 != null) {
            System.out.println(l3.getAuteur());
        } else {
            System.out.println("Le livre " + l3.getId() + " est déja emprunté");
        }
        System.out.println("-------------------------");

        TypedQuery<Livre> query = em.createQuery("SELECT liv FROM Livre liv", Livre.class);

        List<Livre> livres = query.getResultList();
       for (Livre liv : livres) {
           System.out.println("id: " + liv.getId());
           System.out.println("Titre : " + liv.getNom());
           System.out.println("Auteur : " + liv.getAuteur());
           System.out.println("-------------------------");
       }

//        TypedQuery<Client> queryClient = em.createQuery("SELECT c FROM Client c Where c.id=1", Client.class);
//       List<Client> listeClients = queryClient.getResultList();
//       if (!listeClients.isEmpty()) {
//           Client client = listeClients.getFirst();
//           System.out.println(client);
//       } // voir pourquoi ca ne fonctionne pas et voir boucle + sout

       TypedQuery<Client> query2 = em.createQuery("SELECT c FROM Client c Where c.id=1", Client.class);

       List<Client> clients = query2.getResultList();
       for (Client c : clients) {
           System.out.println("id: " + c.getId());
       }

       // Mettre en place le ManyToMany entre Emprunt et Livre (table de jointure s'appelle Compo)
//
//        Emprunt emprunt = new Emprunt();
//       emprunt.setDateDebut("28/07/26");
//       em.persist(emprunt); // emprunt se trouve dans le contexte de persistence

//        Emprunt emprunt = em.find(Emprunt.class, 1);
//       if(emprunt != null) {
//           for (Livre liv : emprunt.getLivres()) { // requete Select secondaire (LAZY loading)
//               System.out.println(liv);
//           }
//       }
//
//       Client client = em.find(Client.class, 3);
//        System.out.println(client);
//        if(client != null) {
//            for (Emprunt emp : client.getEmprunts()){
//                System.out.println(emp+" : ");
//                for (Livre liv: emp.getLivres()){
//                    System.out.println("\t -" + liv);
//                }
//            }
//        }

        em.close();
        emf.close();
    }
}
