package com.gui.booktracker.controller;

import com.gui.booktracker.model.Book;
import com.gui.booktracker.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository repository; //cria banco de dados

    @PostMapping
    public Book cadastrarLivro(@RequestBody Book book) {
        return repository.save(book); //método do Spring Data JPA para salvar um registro na tabela do banco de dados
    }

    @GetMapping
    public List<Book> listarLivros() {
        return repository.findAll(); //método do Spring Data JPA para buscar todos registros de uma tabela do banco de dados
    }

    @PutMapping("/{id}")
    public Book atualizarProgresso(@PathVariable Long id, @RequestBody Book livroAtualizado) {
        Book livroExistente = repository.findById(id).orElseThrow(); // vai à base e procura livro por id, senão lança um erro
        livroExistente.setPaginasLidas(livroAtualizado.getPaginasLidas()); // atualiza livro na base com valor que veio na requisição
        return repository.save(livroExistente); // salva o livro
    }

    @DeleteMapping("/{id}")
    public void apagarLivro(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
