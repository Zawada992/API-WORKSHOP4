package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "books/all";

    }

    @RequestMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveAddBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/add";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

    @RequestMapping("/edit/{id}")
    public String editBook(@PathVariable long id, Model model) {
        model.addAttribute("book", bookService.get(id));
        return "books/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editBookSave(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/edit";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

    @RequestMapping("/confirm/{id}")
    public String confirmShow(@PathVariable("id") long id, Model model){
        model.addAttribute("id", id);

        return "books/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        bookService.delete(id);

        return "redirect:/admin/books/all";
    }

    @RequestMapping("/show/{id}")
    public String showBook(@PathVariable long id, Model model){
        model.addAttribute("book", bookService.get(id).get());
        return "books/show";
    }


}
