package mk.ukim.finki.emt.library.javaApplication.api;

import mk.ukim.finki.emt.library.javaApplication.domain.Book;
import mk.ukim.finki.emt.library.javaApplication.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BooksController {
    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
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
}
