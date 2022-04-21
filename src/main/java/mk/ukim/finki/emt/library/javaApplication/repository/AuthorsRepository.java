package mk.ukim.finki.emt.library.javaApplication.repository;

import mk.ukim.finki.emt.library.javaApplication.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Author,Long> {

}
