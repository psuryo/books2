package com.example.perpus;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // HTML View
    @GetMapping
    public String getAllBooksHtml(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    // JSON API (keeps your existing API endpoint)
    @GetMapping("/api")
    @ResponseBody
    public List<Map<String, Object>> getAllBooksJson() {
        return bookService.getAllBooks();
    }

    @PostMapping
    @ResponseBody
    public String addBook(@RequestParam String title, @RequestParam String author) {
        bookService.addBook(title, author);
        return "Book added successfully!";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book deleted successfully!";
    }
}