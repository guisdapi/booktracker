package com.gui.booktracker.controller;

import com.gui.booktracker.model.Book;
import com.gui.booktracker.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository repository;

    @PostMapping
    public Book cadastrarLivro(@RequestBody Book book) {
        return repository.save(book);
    }
}
