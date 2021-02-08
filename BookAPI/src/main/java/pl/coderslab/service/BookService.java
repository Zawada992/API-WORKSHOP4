package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.domain.Book;

import java.util.List;
import java.util.Optional;

@Component
public interface BookService {
    List<Book> getBooks();
    void add(Book book);
    void delete(Long id);
    void update(Book book);
    Optional<Book> get(Long id);



}
