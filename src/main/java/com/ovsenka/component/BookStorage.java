package com.ovsenka.component;

import com.ovsenka.entity.Book;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BookStorage {

    private final Map<Integer, Book> storage = new HashMap<>();

    {
        storage.put(1, new Book(1, "Cleanly Code", "Robert Martin"));
        storage.put(2, new Book(2, "Cleanly Architecture", "Robert Martin"));
        storage.put(3, new Book(3, "Basics of PostgreSQL", "Morgunov"));
    }

    public Map<Integer, Book> getStorage() {
        return storage;
    }

    public Book getById(Integer id){
        return storage.get(id);
    }
    public Book add(Book book){
        return storage.put(book.getId(), book);
    }
    public Book deleteById(Integer id){
        return storage.remove(id);
    }
    public Book saveTitle(Integer id, String title){
        Book edited = storage.get(id);
        edited.setTitle(title);
        return storage.replace(id, edited);
    }
    public Book saveAuthor(Integer id, String author){
        Book edited = storage.get(id);
        edited.setAuthor(author);
        return storage.replace(id, edited);
    }
}
