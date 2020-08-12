package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.sample.persistence.entities.Book;
import ru.geekbrains.sample.services.BookService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class BookController {

    public final BookService bookService;

    @GetMapping(value = "/books/filtered", produces = "application/json")
    @ResponseBody
    public List<Book> getBooksByFilter(
        @RequestParam(name = "minPrice", defaultValue = "0") int minPrice,
        @RequestParam(name = "maxPrice", defaultValue = "999999999") int maxPrice
    ) {
        return bookService.getFilterdByPrice(minPrice, maxPrice);
    }

    @GetMapping("/books")
    public String getBooksWithPagination(
        Model model,
        @RequestParam(name = "page", defaultValue = "1") int currentPage,
        @RequestParam(name = "size", defaultValue = "5") int pageSize)
    {
        Page<Book> bookPage = bookService.getWithPagination(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("bookPage", bookPage);

        if (!bookPage.isEmpty()) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, bookPage.getTotalPages())
                                                 .boxed()
                                                 .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "books";
    }

    @GetMapping("/books/{id}")
    public String getBookPage(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.getOne(id));
        return "book";
    }

}
