package br.com.pedro.dto;

public class EditoraDto {
    private String editora;
    private String autor;


    
    public EditoraDto(String nomeEditora, String nomeAutor) {
        
        this.editora = nomeEditora;
        this.autor = nomeAutor;
    }

    
    public EditoraDto() {
    }


    public String getEditora() {
        return editora;
    }
    public void setEditora(String nomeEditora) {
        this.editora = nomeEditora;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String nomeAutor) {
        this.autor = nomeAutor;
    }
    
}
