package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.DTO.AuthorDTO;
import com.example.Library.Management.System.Entity.Author;
import com.example.Library.Management.System.Mapper.AuthorMapper;
import com.example.Library.Management.System.Repository.AuthorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepo repo;
    private final AuthorMapper mapper;

    public AuthorService(AuthorRepo repo, AuthorMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public AuthorDTO create(AuthorDTO dto) {
        Author author = mapper.toEntity(dto);
        return mapper.toDto(repo.save(author));

    }

    public List<AuthorDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public AuthorDTO getAuthorById(Long id){
        return repo.findById(id).map(mapper::toDto).orElse(null);
    }

    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO){
        Author author = repo.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        author.setName(authorDTO.getName());
        return mapper.toDto(repo.save(author));
    }

    public void deleteAuthor(Long id){
        repo.deleteById(id);
    }

}
