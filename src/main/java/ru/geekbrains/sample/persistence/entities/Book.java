package ru.geekbrains.sample.persistence.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;

@Data
@Entity
public class Book {

    @Id
    public int id;

    public String name;

    public Date created;

    public String description;

    public boolean available;

    public double price;

}
