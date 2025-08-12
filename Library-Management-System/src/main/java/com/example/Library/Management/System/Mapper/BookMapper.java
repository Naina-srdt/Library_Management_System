package com.example.Library.Management.System.Mapper;

import com.example.Library.Management.System.DTO.BookDTO;
import com.example.Library.Management.System.Entity.Author;
import com.example.Library.Management.System.Entity.Book;
import com.example.Library.Management.System.Entity.Publisher;
import com.example.Library.Management.System.ExceptionHandling.CustomException;
import com.example.Library.Management.System.Repository.AuthorRepo;
import com.example.Library.Management.System.Repository.PublisherRepo;
import org.springframework.stereotype.Component;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Component
public class BookMapper {

    private final AuthorRepo authorRepo;
    private final PublisherRepo publisherRepo;

    public BookMapper(AuthorRepo authorRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.publisherRepo = publisherRepo;
    }

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


    public Book toEntity(BookDTO bookDTO){
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());

        Author author = authorRepo.findById(bookDTO.getAuthorId())
                .orElseThrow(() -> new CustomException("Author not Found with id " + id));
        book.setAuthor(author);

        Publisher publisher = publisherRepo.findById(bookDTO.getPublisherId())
                .orElseThrow(() -> new CustomException("Publisher not Found with id " + id));
        book.setPublisher(publisher);

        return book;
    }



}
