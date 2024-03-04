package br.com.pedro.dao;

import org.hibernate.annotations.GeneratedColumn;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livrohasautor")
public class LivroHasAutor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLivroHasAutor;
    
    @ManyToOne
    @JoinColumn (name = "idLivro")
    private Livros livros;
    @ManyToOne
    @JoinColumn (name = "idAutor")
    private Autor autor;
    


    public LivroHasAutor() {
    }



    public LivroHasAutor(int idLivroHasAutor, Livros livros, Autor autor) {
        this.idLivroHasAutor = idLivroHasAutor;
        this.livros = livros;
        this.autor = autor;
    }



    public int getIdLivroHasAutor() {
        return idLivroHasAutor;
    }



    public void setIdLivroHasAutor(int idLivroHasAutor) {
        this.idLivroHasAutor = idLivroHasAutor;
    }



    public Livros getLivros() {
        return livros;
    }



    public void setLivros(Livros livros) {
        this.livros = livros;
    }



    public Autor getAutor() {
        return autor;
    }



    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    
   


   
    

}
