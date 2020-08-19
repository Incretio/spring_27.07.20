package ru.geekbrains.sample.persistence.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Item {

    @Id
    private UUID id;
    private String title;
    private double price;

}
