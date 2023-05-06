package com.ovsenka.service;

import com.ovsenka.entity.Book;
import com.ovsenka.component.BookStorage;
import com.ovsenka.repository.BookRepository;
import com.ovsenka.requests.RequestBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ovsenka.requests.*;

import java.util.Optional;


@Service
public class BookService{
    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public RequestBook getBook(Integer id){
        RequestBook response;
        Optional<Book> optBook = bookRepository.findById(id);
        if (optBook.isPresent()){
            response = new RequestBook(optBook.get());
        }
        else
            throw new IllegalArgumentException();
        return response;
    }
    public ResultRequest addBook(RequestBook request){
        if (request.getId() == null) throw new IllegalArgumentException();
        else{
            Book newBook = new Book(request.getId(), request.getTitle(), request.getAuthor());
            bookRepository.save(newBook);
            return new ResultRequest(true);
        }

    }
    public ResultRequest deleteBook(Integer id){
        if (!bookRepository.existsById(id)){
            return new ResultRequest(false);
        }
        bookRepository.deleteById(id);
        return new ResultRequest(true);
    }
    public ResultRequest updateBook(RequestOnPatch request){
        return new ResultRequest(false);
    }

}
