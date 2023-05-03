package com.ovsenka;

import com.ovsenka.requests.RequestBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ovsenka.requests.*;


@Service
public class BookService{
    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public RequestBook getBook(Integer id){
        Book book = bookRepository.getById(id);
        if (book == null) throw new IllegalArgumentException();
        RequestBook response = new RequestBook(book);
        return response;
    }
    public ResultRequest addBook(RequestBook request){
        if (request.getId() == null) throw new IllegalArgumentException();
        if (bookRepository.add(new Book(request.getId(),
                        request.getTitle(),
                        request.getAuthor())) != null)
            return new ResultRequest(true);
        return new ResultRequest(false);
    }
    public ResultRequest deleteBook(Integer id){
        if (bookRepository.deleteById(id) == null) throw new IllegalArgumentException();
        return new ResultRequest(true);
    }
    public ResultRequest updateBook(RequestOnPatch request){
        if (bookRepository.getById(request.getId()) == null || request.getKey() == null)
            return new ResultRequest(false);
        if (request.getKey().equals("title") || request.getKey().equals("author")) {
            String key = request.getKey();
            if (key.equals("title")) {
                if (bookRepository.saveTitle(request.getId(), request.getValue()) != null)
                    return new ResultRequest(true);
            }
            if (key.equals("author")) {
                if (bookRepository.saveAuthor(request.getId(), request.getValue()) != null)
                    return new ResultRequest(true);
            }

        }
        return new ResultRequest(false);
    }

}
