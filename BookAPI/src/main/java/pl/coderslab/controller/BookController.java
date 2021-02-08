package pl.coderslab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.domain.Book;
import pl.coderslab.service.BookService;


import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    public List<Book> getList() {
        return bookService.getBooks();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book){
        bookService.add(book);
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id){
        bookService.delete(id);

    }

//    @RequestMapping(value = "", method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book book){
        book.setId(id);
        bookService.update(book);
    }



    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id){
        return this.bookService.get(id).orElseThrow(()-> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found!!!");
        });
    }

}
