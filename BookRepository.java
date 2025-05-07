package com.example.perpus;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Custom JPQL query to find books by title
    @Query("SELECT b FROM Book b WHERE b.title = :title")
    List<Book> findBooksByTitle(@Param("title") String title);

    // Custom native SQL query to find books by author
    @Query(value = "SELECT * FROM book WHERE author = :author", nativeQuery = true)
    List<Book> findBooksByAuthor(@Param("author") String author);
}
