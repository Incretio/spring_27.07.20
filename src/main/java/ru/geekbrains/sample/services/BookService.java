package ru.geekbrains.sample.services;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import ru.geekbrains.sample.persistence.entities.Book;
import ru.geekbrains.sample.persistence.entities.School;
import ru.geekbrains.sample.persistence.repositories.BookRepository;
import ru.geekbrains.sample.persistence.repositories.SchoolRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final SchoolRepository schoolRepository;


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getOne(UUID id) {
        return bookRepository.findById(id).orElse(null);
    }

}