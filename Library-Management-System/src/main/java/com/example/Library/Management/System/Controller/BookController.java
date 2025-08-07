package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.DTO.BookDTO;
import com.example.Library.Management.System.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    //Add A New Book
    @PostMapping("/add")
    public BookDTO createBook(@RequestBody BookDTO bookDTO){
        return service.createBook(bookDTO);
    }

    //Get All
    @GetMapping
    public List<BookDTO> getAllBooks(){
        return service.getAllBooks();
    }

    //Get Book by id
    @GetMapping("/{id}")
    public BookDTO getById(@PathVariable Long id){
        return service.getBookById(id);
    }

    //Delete Book by id
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }

    //Update Book
    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO){
        return service.updateBook(id, bookDTO);
    }

    //Get Book by Author id
    @GetMapping("/author/{authorId}")
    public List<BookDTO> getBooksByAuthorId(@PathVariable Long authorId){
        return service.getBooksByAuthorId(authorId);
    }

    //Get Book by Publisher country
    @GetMapping("/publisher/country/{country}")
    public List<BookDTO> findBooksByPublisherCountry(@PathVariable String country){
        return service.findBooksByPublisherCountry(country);
    }
}
