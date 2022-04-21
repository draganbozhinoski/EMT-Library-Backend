package mk.ukim.finki.emt.library.javaApplication.domain;

import lombok.Data;
import mk.ukim.finki.emt.library.javaApplication.domain.enums.Category;

import javax.persistence.*;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Integer availableCopies;
    @Enumerated(value = EnumType.STRING)
    Category category;
    @ManyToOne
    Author author;

    public Book() {
    }

    public Book(String name, Integer availableCopies, Category category, Author author) {
        this.name = name;
        this.availableCopies = availableCopies;
        this.category = category;
        this.author = author;
    }
}
