package com.example.Library.Management.System.DTO;

import lombok.Data;

@Data
public class BookDTO {

    private Long id;
    private String title;
    private Long authorId;
    private Long publisherId;
}
