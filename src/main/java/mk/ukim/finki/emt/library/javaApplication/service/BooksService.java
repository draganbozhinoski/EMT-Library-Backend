package mk.ukim.finki.emt.library.javaApplication.service;

import mk.ukim.finki.emt.library.javaApplication.domain.Author;
import mk.ukim.finki.emt.library.javaApplication.domain.Book;
import mk.ukim.finki.emt.library.javaApplication.domain.enums.Category;
import mk.ukim.finki.emt.library.javaApplication.repository.BooksRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BooksRepository booksRepository;
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }
    public Book findById(Long id) {
        Optional<Book> bookOpt = booksRepository.findById(id);
        return bookOpt.orElse(null);
    }
    @Transactional
    public void updateCopies(Long bookId,Integer copies) {
        if(copies >= 0) {
            booksRepository.updateCopies(bookId, copies);
        }
    }
    @Transactional
    public void updateBook(Long id,String name,Integer availableCopies, Author author,Category category) {
        booksRepository.updateBook(id,name,availableCopies,author,category);
    }
    public void deleteBook(Long bookId) {
        Optional<Book> book = booksRepository.findById(bookId);
        if(book.isPresent()) {
            booksRepository.delete(booksRepository.findById(bookId).get());
        }
    }
    public void saveBook(String name, Integer availableCopies, Author author, Category category) {
        booksRepository.save(new Book(name,availableCopies,category,author));
    }
}
