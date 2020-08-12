package ru.geekbrains.sample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ru.geekbrains.sample.persistence.entities.Book;
import ru.geekbrains.sample.persistence.repositories.BookRepository;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getOne(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Page<Book> getWithPagination(Pageable pageable) {
        List<Book> books = bookRepository.findAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Book> list;

        if (books.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, books.size());
            list = books.subList(startItem, toIndex);
        }

        return new PageImpl<Book>(list, PageRequest.of(currentPage, pageSize), books.size());
    }

    public List<Book> getFilterdByPrice(int minPrice, int maxPrice) {
        return bookRepository.getBooksByPriceBetween(minPrice, maxPrice);
    }

}