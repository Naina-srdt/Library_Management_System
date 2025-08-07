package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.DTO.BookDTO;
import com.example.Library.Management.System.Entity.Author;
import com.example.Library.Management.System.Entity.Book;
import com.example.Library.Management.System.Entity.Publisher;
import com.example.Library.Management.System.Mapper.BookMapper;
import com.example.Library.Management.System.Repository.AuthorRepo;
import com.example.Library.Management.System.Repository.BookRepo;
import com.example.Library.Management.System.Repository.PublisherRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookService {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;
    private final PublisherRepo publisherRepo;


    public BookService(BookRepo bookRepo, AuthorRepo authorRepo, PublisherRepo publisherRepo, BookMapper bookMapper) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.publisherRepo = publisherRepo;
    }

    public BookDTO createBook(BookDTO bookDTO) {
        if (bookDTO.getAuthorId() == null) {
            throw new IllegalArgumentException("Author ID must not be null");
        }

        if (bookDTO.getPublisherId() == null) {
            throw new IllegalArgumentException("Publisher ID must not be null");
        }

        Author author = authorRepo.findById(bookDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Publisher publisher = publisherRepo.findById(bookDTO.getPublisherId())
                .orElseThrow(() -> new RuntimeException("Publisher not found"));

        Book book = BookMapper.toEntity(bookDTO, author, publisher);
        return BookMapper.toDto(bookRepo.save(book));
    }

    public List<BookDTO> getAllBooks(){
        return bookRepo.findAll().stream().map(BookMapper::toDto).collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id){
        return bookRepo.findById(id).map(BookMapper::toDto).orElse(null);
    }

    public void deleteBook(Long id){
        bookRepo.deleteById(id);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO){
        Book book = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found"));
        book.setTitle(bookDTO.getTitle());
        return BookMapper.toDto(bookRepo.save(book));
    }

    public List<BookDTO> getBooksByAuthorId(Long authorId){
        return bookRepo.getBooksByAuthorId(authorId).stream().map(BookMapper::toDto).collect(Collectors.toList());
    }

    public List<BookDTO> findBooksByPublisherCountry(String country){
        return bookRepo.findBooksByPublisherCountry(country).stream().map(BookMapper::toDto).collect(Collectors.toList());
    }

}
