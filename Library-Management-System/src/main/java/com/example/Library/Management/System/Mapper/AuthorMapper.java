package com.example.Library.Management.System.Mapper;

import com.example.Library.Management.System.DTO.AuthorDTO;
import com.example.Library.Management.System.Entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorDTO toDto(Author author) {
        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setNationality(author.getNationality());
        return dto;
    }

    public Author toEntity(AuthorDTO dto) {
        Author author = new Author();
        author.setId(dto.getId());
        author.setName(dto.getName());
        author.setNationality(dto.getNationality());
        return author;
    }
}
