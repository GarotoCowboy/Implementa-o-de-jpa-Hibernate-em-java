package br.com.pedro.crud;

import java.util.List;

import br.com.pedro.dao.Editora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class CrudEditora {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    Editora editora;

    public void read( int id){
        editora = entityManager.find(Editora.class, id);
        System.out.println("-------------------");
        System.out.println("id: " + editora.getIdEditora() + "  nome: " + editora.getNome());
        // entityManager.close();
        // entityManagerFactory.close();
       
    }

    public void insert(String nome){
        editora = new Editora();
        editora.setNome(nome);
        entityManager.getTransaction().begin();
        entityManager.persist(editora);
        entityManager.getTransaction().commit();
        // entityManager.close();
        // entityManagerFactory.close();

    }

    public void delete(int id){
        editora = entityManager.find(Editora.class, id);
       entityManager.getTransaction().begin();
       entityManager.remove(editora);
       entityManager.getTransaction().commit();
    //    entityManager.close();
    //    entityManagerFactory.close();

    }

    public void update(int id, String nome){
        editora = new Editora();
        editora.setIdEditora(id);
        editora.setNome(nome);

        entityManager.getTransaction().begin();
        entityManager.merge(editora);
        entityManager.getTransaction().commit();
        // entityManager.close();
        // entityManagerFactory.close();

    }

   

}
