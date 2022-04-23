package mk.ukim.finki.emt.library.javaApplication.service;

import mk.ukim.finki.emt.library.javaApplication.domain.Author;
import mk.ukim.finki.emt.library.javaApplication.repository.AuthorsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorsService {
    private final AuthorsRepository authorsRepository;

    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }
    public List<Author> findAll() {
        return authorsRepository.findAll();
    }
    public Author findById(Long id) {
        return authorsRepository.findById(id).orElse(null);
    }
}
