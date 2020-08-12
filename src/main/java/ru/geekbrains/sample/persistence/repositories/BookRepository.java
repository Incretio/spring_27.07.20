package ru.geekbrains.sample.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.geekbrains.sample.persistence.entities.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> getBooksByPriceBetween(double minPrice, double maxPrice);
}