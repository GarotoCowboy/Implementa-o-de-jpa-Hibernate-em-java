package br.com.pedro.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAutor;

    private String nome;

    

    public Autor(int id, String nome) {
        this.idAutor = id;
        this.nome = nome;
    }

    public Autor() {
    }

    public int getId() {
        return idAutor;
    }

    public void setId(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
