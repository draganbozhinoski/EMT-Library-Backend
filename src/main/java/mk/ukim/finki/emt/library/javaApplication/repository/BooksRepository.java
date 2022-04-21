package mk.ukim.finki.emt.library.javaApplication.repository;

import mk.ukim.finki.emt.library.javaApplication.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book,Long> {
    @Query("update Book b set b.availableCopies=:copies where b.id=:bookId")
    @Modifying
    void updateCopies(Long bookId,Integer copies);
}
