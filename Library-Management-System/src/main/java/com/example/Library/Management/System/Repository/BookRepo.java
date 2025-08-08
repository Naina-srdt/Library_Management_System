package com.example.Library.Management.System.Repository;

import com.example.Library.Management.System.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    // JPQL - Get all books by Author ID
    @Query("select b FROM Book b WHERE b.author.id = :authorId")
    List<Book> getBooksByAuthorId(@Param("authorId") Long authorId);

    // Native - Get all books by Publisher country
//    @Query(value = "SELECT * FROM book b JOIN publisher p ON b.publisher_id = p.id WHERE p.country = :country", nativeQuery = true)
//    List<Book> findBooksByPublisherCountry(@Param("country") String country);

    @Query(value = "SELECT b.* FROM book b JOIN publisher p ON b.publisher_id = p.id WHERE p.country = :country", nativeQuery = true)
    List<Book> findBooksByPublisherCountry(@Param("country") String country);

    //JPQL - Get all books by Publisher ID
    @Query("select b from Book b where b.publisher.id = :publisherId")
    List<Book> getBooksByPublisherId(@Param("publisherId") Long publisherId);
}
