package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.DTO.AuthorDTO;
import com.example.Library.Management.System.Entity.Author;
import com.example.Library.Management.System.Service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    //Constructor Injection
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    //create an Author
    @PostMapping("/add")
    public AuthorDTO create(@RequestBody AuthorDTO authorDTO){
       return service.create(authorDTO);
    }

    //Get all Authors
    @GetMapping
    public List<AuthorDTO> getAll(){
        return service.getAll();
    }

    //Get Authors by id
    //Change
    @GetMapping("/{id}")
    public Author getById(@PathVariable Long id){
        return service.getAuthorById(id);
    }

    //Delete Author by id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         service.deleteAuthor(id);
    }

    //Update author by id
    @PutMapping("/{id}")
    public AuthorDTO updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO){
      return service.updateAuthor(id, authorDTO);
    }
}
