package com.ovsenka.app.controllers;

import com.ovsenka.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ovsenka.app.requests.*;


@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    public RequestBook getBook(@PathVariable Integer bookId){
        return bookService.getBook(bookId);
    }

    @PostMapping
    public ResultRequest addBook(@RequestBody RequestBook request){
        return bookService.addBook(request);
    }
    @DeleteMapping("/{bookId}/delete")
    public ResultRequest deleteBook(@PathVariable Integer bookId){
        return bookService.deleteBook(bookId);
    }
    @PatchMapping("/update")
    public ResultRequest updateBook(@RequestBody RequestOnPatch request){
        return bookService.updateBook(request);
    }

}
