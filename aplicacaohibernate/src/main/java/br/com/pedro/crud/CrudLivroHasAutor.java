package br.com.pedro.crud;

import java.util.List;

import br.com.pedro.dao.Autor;
import br.com.pedro.dao.LivroHasAutor;
import br.com.pedro.dao.Livros;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class CrudLivroHasAutor {
    
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    private LivroHasAutor livroHasAutor2;

    public void /*LivroHasAutor*/ read(int id) {
        LivroHasAutor livroHasAutor = entityManager.find(LivroHasAutor.class, id);
        System.out.println("------------------");
        //return entityManager.find(LivroHasAutor.class, id);
        System.out.println("Id livrohasAutor "+ livroHasAutor.getIdLivroHasAutor() +"Id Autor: " + livroHasAutor.getAutor().getId() + " id Livro:" + livroHasAutor.getLivros().getIdLivro());
        // entityManager.close();
        // entityManagerFactory.close();
    }

    public void insert(Autor autor, Livros livro) {
        LivroHasAutor livroHasAutor = new LivroHasAutor();
        livroHasAutor.setAutor(autor);
        livroHasAutor.setLivros(livro);
        entityManager.getTransaction().begin();
        entityManager.persist(livroHasAutor);
        entityManager.getTransaction().commit();
        // entityManager.close();
        // entityManagerFactory.close();
    }

    public void delete(int id) {
        LivroHasAutor livroHasAutor = entityManager.find(LivroHasAutor.class, id);
        if (livroHasAutor != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(livroHasAutor);
            entityManager.getTransaction().commit();
            // entityManager.close();
            // entityManagerFactory.close();

        }
    }

    public void update(int id, Autor autor, Livros livro) {
       // LivroHasAutor livroHasAutor = entityManager.find(LivroHasAutor.class, id);
       LivroHasAutor livroHasAutor = new LivroHasAutor();
            entityManager.getTransaction().begin();
            livroHasAutor.setIdLivroHasAutor(id);
            livroHasAutor.setAutor(autor);
            livroHasAutor.setLivros(livro);

            entityManager.merge(livroHasAutor);
            entityManager.getTransaction().commit();
            // entityManager.close();
            // entityManagerFactory.close();
    }

    // public void closeEntityManager() {
    //     entityManager.close();
    // }

    // // public static void closeEntityManagerFactory() {
    //     entityManagerFactory.close();
    // }


    public void livroParaAutor(String tituloLivro) {
        String jpql = "SELECT a FROM Autor a " +
                        "JOIN LivroHasAutor lha ON lha.autor.id = a.id " +
                        "JOIN Livros l ON lha.livros.id = l.id " +
                        "WHERE l.titulo = :titulo";
    
        TypedQuery<Autor> query = entityManager.createQuery(jpql, Autor.class);
        query.setParameter("titulo", tituloLivro);
    
        List<Autor> listaAutores = query.getResultList();
    
        if (listaAutores.isEmpty()) {
            System.out.println("Nenhum autor encontrado para o livro com o título: " + tituloLivro);
        } else {
            System.out.println("Autores do livro '" + tituloLivro + "':");
            for (Autor autor : listaAutores) {
                System.out.println(autor.getNome());
            }
        }
        System.out.println(tituloLivro);
    }
    
    
    

    public void autorParaLivro(String nomeAutor) {
        String jpql = "SELECT l FROM Livros l " +
                        "JOIN LivroHasAutor lha ON lha.livros.id = l.id "+ 
                        "JOIN Autor a ON lha.autor.id = a.id " +
                        "WHERE a.nome = :nomeAutor";

        
        TypedQuery<Livros> query = entityManager.createQuery(jpql, Livros.class);
        query.setParameter("nomeAutor", nomeAutor);
        
        List<Livros> listaLivro = query.getResultList();
        
        if(listaLivro.isEmpty()){
            System.out.println("Autor não encontrado!!!");
        }else{
            System.out.println("Livros pelo Autor: '" + nomeAutor + "':");

        for (Livros livro : listaLivro) {
            System.out.println(livro.getTitulo());
        }
    }
    
        // entityManager.close();
        // entityManagerFactory.close();
    }
    

}

