package br.com.pedro.dto;

public class LivroPorEditoraDto {
    private String livro;
    private String editora;

    

    public LivroPorEditoraDto(String editora,String livro) {
        this.livro = livro;
        this.editora = editora;
    }
    public String getLivro() {
        return livro;
    }
    public void setLivro(String livro) {
        this.livro = livro;
    }
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }

    
}
