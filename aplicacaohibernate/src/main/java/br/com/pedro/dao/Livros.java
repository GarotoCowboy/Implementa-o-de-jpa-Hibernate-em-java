package br.com.pedro.dao;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livro ")
public class Livros {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLivro;

    private String titulo;
    private int anoPub;
    private String isbn;

    // @ManyToOne
    // @JoinColumn(name = "idAutor")
    // private Autor  autor;

    @ManyToOne
    @JoinColumn (name = "idEditora")
    private Editora editora;

    public Livros() {
    }

    public Livros(int idLivro, String titulo, int anoPub, String isbn, /*Autor Autor,*/ Editora editora) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.anoPub = anoPub;
        this.isbn = isbn;
       // this.autor = autor;
        this.editora = editora;
    }
    public int getIdLivro() {
        return idLivro;
    }
    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String nome) {
        this.titulo = nome;
    }
    public int getAnoPub() {
        return anoPub;
    }
    public void setAnoPub(int anoPub) {
        this.anoPub = anoPub;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // public Autor getAutor() {
    //     return autor;
    // }

    // public void setAutor(Autor autor) {
    //     this.autor = autor;
    // }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "Livros [idLivro=" + idLivro + ", titulo=" + titulo + ", anoPub=" + anoPub + ", isbn=" + isbn
                + ", editora=" + editora + "]";
    }

    
}
