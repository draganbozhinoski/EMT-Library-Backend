package mk.ukim.finki.emt.library.javaApplication.api.request;

import lombok.Data;
import mk.ukim.finki.emt.library.javaApplication.domain.Author;
import mk.ukim.finki.emt.library.javaApplication.domain.enums.Category;

@Data
public class BookRequest {
    String name;
    Integer availableCopies;
    Category category;
    Long author;

    public BookRequest(String name, Integer availableCopies, Category category, Long author) {
        this.name = name;
        this.availableCopies = availableCopies;
        this.category = category;
        this.author = author;
    }
}
