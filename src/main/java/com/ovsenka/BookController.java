package com.ovsenka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ovsenka.requests.*;


@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    public RequestBook getBook(@PathVariable Integer bookId){
        return bookService.getBook(bookId);
    }

    @PostMapping
    public ResultRequest addBook(@RequestBody RequestBook request){
        if (request.getId() == null) throw new IllegalArgumentException();
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
