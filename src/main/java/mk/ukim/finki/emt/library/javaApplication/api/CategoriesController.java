package mk.ukim.finki.emt.library.javaApplication.api;

import mk.ukim.finki.emt.library.javaApplication.domain.enums.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriesController {
    @GetMapping
    public List<Category> getAllCategories() {
        return Arrays.stream(Category.values()).toList();
    }
}
