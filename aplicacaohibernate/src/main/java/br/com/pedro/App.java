package br.com.pedro;

import java.util.Scanner;

import br.com.pedro.crud.CrudAutor;
import br.com.pedro.crud.CrudEditora;
import br.com.pedro.crud.CrudLivroHasAutor;
import br.com.pedro.crud.CrudLivros;
import br.com.pedro.dao.Autor;
import br.com.pedro.dao.Editora;
import br.com.pedro.dao.LivroHasAutor;
import br.com.pedro.dao.Livros;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */

public class App {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {

        CrudAutor autor = new CrudAutor();

        CrudLivros livros = new CrudLivros();
        CrudEditora editora = new CrudEditora();
        CrudLivroHasAutor livroHasAutor = new CrudLivroHasAutor();
        // Autor teste = new Autor();
        // teste.setId(2);

        // Autor autor2 = new Autor();
        // Editora editora2 = new Editora();

        boolean running = true;
        Scanner ler = new Scanner(System.in);

        String titulo;
        String isbn;
        int anoPub;
        int id;
        String nome;
        Autor autorSwitch = new Autor();
        Livros livroSwitch = new Livros();
        String count;
        System.out.println("\n\n\n");
        System.out.println("-----------------Menu---------------");
        System.out.println("1l--Insercao de livros");
        System.out.println("2l -- leitura de livro baseado em id");
        System.out.println("3l -- atualizar livro");
        System.out.println("4l -- Remover Livro");
        System.out.println("1a -- Inserção de Autor");
        System.out.println("2a -- Leitura de Autor baseado em id");
        System.out.println("3a -- Atualizar Autor");
        System.out.println("4a -- Remover Autor");
        System.out.println("1e -- Inserção de Editora");
        System.out.println("2e -- Leitura de Editora baseado em id");
        System.out.println("3e -- Atualizar Editora");
        System.out.println("4e -- Remover Editora");
        System.out.println("1la -- Inserção de Autor em livro");
        System.out.println("2la -- Leitura de Autor em livro baseado em id");
        System.out.println("3la -- Atualizar Autor em livro");
        System.out.println("4la -- Remover Autor em livro");
        System.out.println("-----------Metodos de Leitura Especiais------------");
        System.out.println("1ee -- Autor para Livro");
        System.out.println("2ee -- Livro para Autor");
        System.out.println("3ee -- Editora por livro");
        System.out.println("4ee -- Livro por editora");
        System.out.println("5ee -- Editora por autores e autores por editora");
        System.out.println("ss -- Sair");
        System.out.println("mm -- Listar Menu");
        // autor.update(2,"Autor2");
        do {
            System.out.println("digite uma das opção acima: ");
            count = ler.next();
            ler.nextLine(); // limpa buffer de entrada.
            switch (count) {
                case "1l":
                    System.out.println("Inserção de Livros");
                    System.out.println("insira o titulo: ");
                    titulo = ler.next();

                    System.out.println("insira o isbn: ");
                    isbn = ler.next();

                    System.out.println("insira o ano de publicação: ");
                    anoPub = ler.nextInt();

                    System.out.println("Insira a editora: ");
                    Editora editoraInsertLivro = new Editora();
                    editoraInsertLivro.setIdEditora(ler.nextInt());

                    livros.insert(titulo, isbn, anoPub, editoraInsertLivro);
                    break;
                case "2l":
                    System.out.println("Selecionou leitura de livro baseada em id");
                    System.out.println("digite o id do livro: ");
                    id = ler.nextInt();
                    livros.read(id);
                    break;

                case "3l":
                    System.out.println("Atualizar Livro");
                    System.out.println("Insira o id do livro:");
                    id = ler.nextInt();
                    System.out.println("insira o titulo: ");
                    titulo = ler.next();

                    System.out.println("insira o isbn: ");
                    isbn = ler.next();

                    System.out.println("insira o ano de publicação: ");
                    anoPub = ler.nextInt();

                    System.out.println("Insira a editora: ");
                    editoraInsertLivro = new Editora();
                    editoraInsertLivro.setIdEditora(ler.nextInt());

                    livros.update(id, titulo, isbn, anoPub, editoraInsertLivro);
                    break;

                case "4l":
                    System.out.println("Remover livro");
                    System.out.println("selecione o id do livro:");
                    id = ler.nextInt();
                    livros.delete(id);
                    break;

                case "1a":
                    System.out.println("Inserção de Autor");

                    System.out.println("insira o nome do Autor: ");
                    nome = ler.next();
                    autor.insert(nome);

                    break;

                case "2a":
                    System.out.println("Selecionou leitura de autor baseada em id");
                    System.out.println("digite o id do autor: ");
                    id = ler.nextInt();
                    autor.read(id);
                    break;

                case "3a":
                    System.out.println("Atualizar Autor");

                    System.out.println("Insira o id do Autor:");
                    id = ler.nextInt();

                    System.out.println("insira o nome do Autor a ser atualizado:");
                    nome = ler.next();

                    autor.update(id, nome);

                    break;

                case "4a":
                    System.out.println("Remoção de Autor");

                    System.out.println("Digite o id do Autor a ser Removido: ");
                    id = ler.nextInt();

                    autor.delete(id);
                    break;

                case "1e":
                    System.out.println("Inserção de Editora");

                    System.out.println("insira o nome da Editora: ");
                    nome = ler.next();
                    editora.insert(nome);

                    break;

                case "2e":
                    System.out.println("Selecionou leitura de Editora baseada em id");

                    System.out.println("digite o id da Editora: ");
                    id = ler.nextInt();

                    editora.read(id);
                    break;

                case "3e":
                    System.out.println("Atualizar Editora");

                    System.out.println("Insira o id da Editora:");
                    id = ler.nextInt();

                    System.out.println("insira o nome da Editora a ser atualizado:");
                    nome = ler.next();

                    editora.update(id, nome);

                    break;

                case "4e":
                    System.out.println("Remoção de Editora");
                    System.out.println("Digite o id da Editora a ser Removido: ");
                    id = ler.nextInt();

                    editora.delete(id);

                    break;

                case "1la":
                    System.out.println("Inserção de Livro tem Autor");

                    System.out.println("insira o id do Livro: ");
                    id = ler.nextInt();
                    livroSwitch.setIdLivro(id);

                    System.out.println("insira o id do Autor:");
                    int idAutor = ler.nextInt();
                    autorSwitch.setId(idAutor);

                    livroHasAutor.insert(autorSwitch, livroSwitch);
                    break;

                case "2la":
                    System.out.println("Selecionou leitura de Livro tem autor baseada em id");

                    System.out.println("digite o id do livro tem autor: ");
                    id = ler.nextInt();

                    livroHasAutor.read(id);
                    break;

                case "3la":
                    LivroHasAutor livroAutor = new LivroHasAutor();

                    System.out.println("Atualizar Livro tem Autor");

                    System.out.println("Insira o id do Livro tem Autor: ");
                    id = ler.nextInt();
                    livroAutor.setIdLivroHasAutor(id);

                    System.out.println("Insira o id do livro: ");
                    id = ler.nextInt();
                    livroSwitch.setIdLivro(id);

                    System.out.println("Insira o id do Autor");
                    idAutor = ler.nextInt();
                    autorSwitch.setId(idAutor);

                    livroHasAutor.update(idAutor, autorSwitch, livroSwitch);

                    break;

                case "4la":
                    System.out.println("Remoção de Livro tem Autor");
                    System.out.println("Digite o id do livro tem Autor: ");
                    id = ler.nextInt();

                    livroHasAutor.delete(id);

                    break;

                case "1ee":
                    System.out.println("Autor para Livro");

                    System.out.println("Digite o nome do autor: ");
                    nome = null;
                    nome = ler.nextLine();
                    // ler.nextLine(); //Limpar Buffer
                    // ler.nextLine();

                    livroHasAutor.autorParaLivro(nome);
                    break;

                case "2ee":
                    System.out.println("Livro para Autor");

                    System.out.println("digite o titulo do livro: ");
                    titulo = ler.nextLine();

                    livroHasAutor.livroParaAutor(titulo);
                    ler.nextLine(); // Limpar buffer
                    break;

                case "3ee":
                    System.out.println("Editora por livro");
                    livros.imprimirEditorasPorLivro();
                    break;

                case "4ee":
                    System.out.println("Livro por editora");
                    livros.listarLivroPorEditora();
                    livros.imprimirLivroPorEditora();

                    break;

                case "5ee":
                    System.out.println("Editora por autores e autores por editora");
                    livros.listarEditorasComAutores();
                    livros.imprimirEditoraComAutores();
                    break;

                case "ss":
                    System.out.println("Saindo...");
                    running = false;
                    break;

                case "mm":
                    System.out.println("\n\n\n");
                    System.out.println("-----------------Menu---------------");
                    System.out.println("1l--Insercao de livros");
                    System.out.println("2l -- leitura de livro baseado em id");
                    System.out.println("3l -- atualizar livro");
                    System.out.println("4l -- Remover Livro");
                    System.out.println("1a -- Inserção de Autor");
                    System.out.println("2a -- Leitura de Autor baseado em id");
                    System.out.println("3a -- Atualizar Autor");
                    System.out.println("4a -- Remover Autor");
                    System.out.println("1e -- Inserção de Editora");
                    System.out.println("2e -- Leitura de Editora baseado em id");
                    System.out.println("3e -- Atualizar Editora");
                    System.out.println("4e -- Remover Editora");
                    System.out.println("1la -- Inserção de Autor em livro");
                    System.out.println("2la -- Leitura de Autor em livro baseado em id");
                    System.out.println("3la -- Atualizar Autor em livro");
                    System.out.println("4la -- Remover Autor em livro");
                    System.out.println("-----------Metodos de Leitura Especiais------------");
                    System.out.println("1ee -- Autor para Livro");
                    System.out.println("2ee -- Livro para Autor");
                    System.out.println("3ee -- Editora por livro");
                    System.out.println("4ee -- Livro por editora");
                    System.out.println("5ee -- Editora por autores e autores por editora");
                    System.out.println("ss -- Sair");

                    break;

                default:
                    System.out.println("opção Invalida...");
            }
        } while (running);

        entityManager.close();
        entityManagerFactory.close();
    }

}
