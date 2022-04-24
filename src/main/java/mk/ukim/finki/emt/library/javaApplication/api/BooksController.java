package mk.ukim.finki.emt.library.javaApplication.api;

import mk.ukim.finki.emt.library.javaApplication.api.request.BookRequest;
import mk.ukim.finki.emt.library.javaApplication.domain.Author;
import mk.ukim.finki.emt.library.javaApplication.domain.Book;
import mk.ukim.finki.emt.library.javaApplication.service.AuthorsService;
import mk.ukim.finki.emt.library.javaApplication.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "https://emt-library-frontend-196060.herokuapp.com/")
public class BooksController {
    private final BooksService booksService;
    private final AuthorsService authorsService;
    public BooksController(BooksService booksService, AuthorsService authorsService) {
        this.booksService = booksService;
        this.authorsService = authorsService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok().body(booksService.findAll());
    }
    @PostMapping("/{id}/take")
    public ResponseEntity<?> markAsTaken(@PathVariable Long id) {
        Book book = booksService.findById(id);
        if(book == null){
            return ResponseEntity.badRequest().body("Book was not found in the database");
        }
        else {
            booksService.updateCopies(book.getId(),book.getAvailableCopies()-1);
            return ResponseEntity.ok().body("Successfully updated copies of the book. Currently: " + (book.getAvailableCopies()-1));
        }
    }
    @DeleteMapping("/{id}/delete")
    public void deleteBook(@PathVariable Long id) {
        booksService.deleteBook(id);
    }
    @GetMapping("/authors")
    public List<Author> findAllAuthors() {
        return authorsService.findAll();
    }
    @PostMapping("/save")
    public void saveBook(@RequestBody BookRequest bookRequest) {
        booksService.saveBook(bookRequest.getName(),bookRequest.getAvailableCopies(),authorsService.findById(bookRequest.getAuthor()),bookRequest.getCategory());
    }
    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return booksService.findById(id);
    }
    @PutMapping("/{id}/update")
    public void updateBook(@PathVariable Long id,
                           @RequestBody BookRequest bookRequest) {
        booksService.updateBook(id,bookRequest.getName(),bookRequest.getAvailableCopies(),authorsService.findById(bookRequest.getAuthor()),bookRequest.getCategory());
    }
}
