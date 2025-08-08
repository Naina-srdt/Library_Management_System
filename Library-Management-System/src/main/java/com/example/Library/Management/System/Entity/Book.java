package com.example.Library.Management.System.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @JsonIgnore
    private Publisher publisher;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "author_id")
    private Author author;
}
