package mk.ukim.finki.emt.library.javaApplication.domain.dataInitializer;

import mk.ukim.finki.emt.library.javaApplication.domain.Author;
import mk.ukim.finki.emt.library.javaApplication.domain.Book;
import mk.ukim.finki.emt.library.javaApplication.domain.Country;
import mk.ukim.finki.emt.library.javaApplication.domain.enums.Category;
import mk.ukim.finki.emt.library.javaApplication.repository.AuthorsRepository;
import mk.ukim.finki.emt.library.javaApplication.repository.BooksRepository;
import mk.ukim.finki.emt.library.javaApplication.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final BooksRepository booksRepository;
    private final AuthorsRepository authorsRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(BooksRepository booksRepository, AuthorsRepository authorsRepository, CountryRepository countryRepository) {
        this.booksRepository = booksRepository;
        this.authorsRepository = authorsRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void initData() {
        Country country1 = new Country("Macedonia","Europe");
        Country country2 = new Country("New Zealand","Australia");
        Country country3 = new Country("China","Asia");
        Country country4 = new Country("Ni*eria","Africa");
        countryRepository.save(country1);
        countryRepository.save(country2);
        countryRepository.save(country3);
        countryRepository.save(country4);
        Author author1 = new Author("Dragan","Bozhinoski",country1);
        Author author2 = new Author("Stole","Stoilov",country2);
        Author author3 = new Author("Ching Chang","Chung",country3);
        Author author4 = new Author("Chuck","Constly",country4);
        authorsRepository.save(author1);
        authorsRepository.save(author2);
        authorsRepository.save(author3);
        authorsRepository.save(author4);
        booksRepository.save(new Book("Harry Potter 1",15,Category.BIOGRAPHY,author1));
        booksRepository.save(new Book("Harry Potter 2",20,Category.CLASSICS,author2));
        booksRepository.save(new Book("Harry Potter 3",35,Category.NOVEL,author2));
        booksRepository.save(new Book("Harry Potter 4",25,Category.DRAMA,author3));
        booksRepository.save(new Book("Harry Potter 5",30,Category.FANTASY,author4));
        booksRepository.save(new Book("Harry Potter 1.1",15,Category.BIOGRAPHY,author1));
        booksRepository.save(new Book("Harry Potter 2.2",20,Category.CLASSICS,author2));
        booksRepository.save(new Book("Harry Potter 3.3",35,Category.NOVEL,author2));
        booksRepository.save(new Book("Harry Potter 4.4",25,Category.DRAMA,author3));
        booksRepository.save(new Book("Harry Potter 5.5",30,Category.FANTASY,author4));
    }
}
