package mk.ukim.finki.emt.library.javaApplication.repository;

import mk.ukim.finki.emt.library.javaApplication.domain.Author;
import mk.ukim.finki.emt.library.javaApplication.domain.Book;
import mk.ukim.finki.emt.library.javaApplication.domain.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book,Long> {
    @Query("update Book b set b.availableCopies=:copies where b.id=:bookId")
    @Modifying
    void updateCopies(Long bookId, Integer copies);

    @Query("update Book b set b.name=:name,b.availableCopies=:availableCopies,b.author=:author,b.category=:category where b.id=:id")
    @Modifying
    void updateBook(Long id, String name, Integer availableCopies, Author author, Category category);
}
