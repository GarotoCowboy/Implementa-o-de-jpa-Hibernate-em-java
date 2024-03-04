package br.com.pedro.crud;

import java.util.ArrayList;

import org.hibernate.mapping.List;

import com.mysql.cj.Session;

import br.com.pedro.App;
import br.com.pedro.dao.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CrudAutor {
      private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    Autor autor;

    public void read(int id){
        autor = entityManager.find(Autor.class, id);
        System.out.println("--------------");
            System.out.println("Id: "+ autor.getId() +"  Nome: " + autor.getNome());
       
    }

    public void insert(String nome){
        autor = new Autor();
        autor.setNome(nome);
        entityManager.getTransaction().begin();
        entityManager.persist(autor);
        entityManager.getTransaction().commit();
        // entityManager.close();
        // entityManagerFactory.close();

    }

    public void delete(int id){
       autor = entityManager.find(Autor.class, id);
       entityManager.getTransaction().begin();
       entityManager.remove(autor);
       entityManager.getTransaction().commit();
    //    entityManager.close();
    //    entityManagerFactory.close();

    }

    public void update(int id, String nome){
        autor = new Autor();
        autor.setId(id);
        autor.setNome(nome);
        entityManager.getTransaction().begin();
        entityManager.merge(autor);
        entityManager.getTransaction().commit();
        // entityManager.close();
        // entityManagerFactory.close();

    }
    

   
}
