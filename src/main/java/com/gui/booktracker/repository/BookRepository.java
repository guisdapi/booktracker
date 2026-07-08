package com.gui.booktracker.repository;

import com.gui.booktracker.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
