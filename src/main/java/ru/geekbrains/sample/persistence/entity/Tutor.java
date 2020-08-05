package ru.geekbrains.sample.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode (callSuper = true)
public class Tutor extends AbstractEntity {
    private String name;
    private int age;
}
