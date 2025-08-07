package com.example.Library.Management.System.Mapper;

import com.example.Library.Management.System.DTO.PublisherDTO;
import com.example.Library.Management.System.Entity.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper {

    public PublisherDTO toDto(Publisher publisher){
        PublisherDTO dto = new PublisherDTO();
        dto.setId(publisher.getId());
        dto.setName(publisher.getName());
        dto.setCountry(publisher.getCountry());
        return dto;
    }

    public Publisher toEntity(PublisherDTO publisherDTO){
        Publisher publisher = new Publisher();
        publisher.setId(publisherDTO.getId());
        publisher.setName(publisherDTO.getName());
        publisher.setCountry(publisherDTO.getCountry());
        return publisher;
    }
}
