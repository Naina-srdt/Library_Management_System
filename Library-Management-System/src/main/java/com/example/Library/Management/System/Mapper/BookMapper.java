package com.example.Library.Management.System.Mapper;

import com.example.Library.Management.System.DTO.BookDTO;
import com.example.Library.Management.System.Entity.Author;
import com.example.Library.Management.System.Entity.Book;
import com.example.Library.Management.System.Entity.Publisher;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public static BookDTO toDto(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());

        if (book.getAuthor() != null) {
            dto.setAuthorId(book.getAuthor().getId());
        } else {
            dto.setAuthorId(null);
        }

        if (book.getPublisher() != null) {
            dto.setPublisherId(book.getPublisher().getId());
        } else {
            dto.setPublisherId(null);
        }
        return dto;
    }

    public static Book toEntity(BookDTO bookDTO, Author author, Publisher publisher){
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(author);
        book.setPublisher(publisher);
        return book;
    }
}
