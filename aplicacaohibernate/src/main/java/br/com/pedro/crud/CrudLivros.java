package br.com.pedro.crud;

import java.util.ArrayList;
import java.util.List;

import br.com.pedro.dao.Autor;
import br.com.pedro.dao.Editora;
import br.com.pedro.dao.Livros;
import br.com.pedro.dto.EditoraDto;
import br.com.pedro.dto.LivroPorEditoraDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class CrudLivros {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    private Livros livros;
  
    public void read( int id){
        Livros livros = entityManager.find(Livros.class, id);
        System.out.println("--------------");
        System.out.println("Id" + livros.getIdLivro());
        System.out.println("titulo:" + livros.getTitulo());
        System.out.println("isbn" + livros.getIsbn());
        System.out.println("ano publicado" + livros.getAnoPub());
        System.out.println("Editora" + livros.getEditora().getNome());


        entityManager.close();
        entityManagerFactory.close();
       
    }

    public void insert(String nome,String isbn, int anoPub, /*Autor autor,*/ Editora editora){
        livros = new Livros();
        livros.setTitulo(nome);
        livros.setIsbn(isbn);
        livros.setAnoPub(anoPub);
        /*livros.setAutor(autor);*/
        livros.setEditora(editora);
        entityManager.getTransaction().begin();
        entityManager.persist(livros);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

    public void delete(int id){
       livros = entityManager.find(Livros.class, id);
       entityManager.getTransaction().begin();
       entityManager.remove(livros);
       entityManager.getTransaction().commit();
    //    entityManager.close();
    //    entityManagerFactory.close();

    }

    public void update(int id, String nome,String isbn, int anoPub,/*Autor autor,*/ Editora editora){
        livros = new Livros();
        livros.setIdLivro(id);
        livros.setTitulo(nome);
        livros.setIsbn(isbn);
        livros.setAnoPub(anoPub);
        livros.setEditora(editora);
       // livros.setAutor(autor);
        entityManager.getTransaction().begin();
        entityManager.merge(livros);
        entityManager.getTransaction().commit();
        // entityManager.close();
        // entityManagerFactory.close();

    }
    
 

    public void selecionarTodosLivros(){
        String sql = "select l from Livros l";
        TypedQuery<Livros> typedQuery = entityManager.createQuery(sql,Livros.class);
    
        List<Livros> listaLivros = typedQuery.getResultList();
    
        for(Livros livro:listaLivros){
            System.out.println(livro.getTitulo());
        }

        // entityManager.close();
        // entityManagerFactory.close();
 



}
    //metodo que faz a busca no banco de dados de editora por livros e as imprime
    public void imprimirEditorasPorLivro() {
        String jpql = "SELECT l.titulo, e.nome FROM Livros l JOIN l.editora e";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> resultados = query.getResultList();

        for (Object[] resultado : resultados) {
            String tituloLivro = (String) resultado[0];
            String nomeEditora = (String) resultado[1];
            System.out.println("Livro: " + tituloLivro + " - Editora: " + nomeEditora);
    }

}


//Metodo que passa uma jpql e retorna uma lista com as informações de quais livros por editora 
//puxadas do banco de dados
public List<LivroPorEditoraDto> listarLivroPorEditora(){
    String jpql = "Select e.nome, l.titulo from Livros l "+
    "join l.editora e "+
    "order by e.nome, l.titulo";


    
    return entityManager.createQuery(jpql, LivroPorEditoraDto.class).getResultList();
}

//Ele pega os valores do metodo listarLivroPorEditora e imprime esses valores
public void imprimirLivroPorEditora(){
    List<LivroPorEditoraDto> livrosPorEditora =listarLivroPorEditora();
    
    for(LivroPorEditoraDto livro: livrosPorEditora){
        System.out.printf("Editora: %s,     Livros: %s",livro.getEditora(),livro.getLivro());
        System.out.println();
    }
}

///Metodo que passa uma jpql e retorna uma lista com as informações puxadas do banco de dados sobre
//Editoras por autor e também autores por editora
public List<EditoraDto> listarEditorasComAutores() {
    String jpql = "SELECT NEW EditoraDto(e.nome, a.nome) FROM LivroHasAutor la "+ 
                    "JOIN la.livros l "+ 
                    "JOIN l.editora e "+ 
                    "JOIN la.autor a "+ 
                    "ORDER BY e.nome, a.nome";


    return entityManager.createQuery(jpql, EditoraDto.class).getResultList();
}

//metodo responsavel por fazer a impressão do metodo listarEditorasComAutores
public void imprimirEditoraComAutores() {
    List<EditoraDto> editoras = listarEditorasComAutores();

    for (EditoraDto editora : editoras) {
        System.out.println("Nome da Editora: " + editora.getEditora());
        System.out.println("Nome do Autor: " + editora.getAutor());
        System.out.println();
    }
}

}
