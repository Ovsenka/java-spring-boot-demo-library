package com.ovsenka.app.repository;

import com.ovsenka.app.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
