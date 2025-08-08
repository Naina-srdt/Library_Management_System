package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.DTO.PublisherDTO;
import com.example.Library.Management.System.Entity.Publisher;
import com.example.Library.Management.System.ExceptionHandling.CustomException;
import com.example.Library.Management.System.Mapper.PublisherMapper;
import com.example.Library.Management.System.Repository.PublisherRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    private final PublisherRepo publisherRepo;
    private final PublisherMapper publisherMapper;

    public PublisherService(PublisherRepo publisherRepo, PublisherMapper publisherMapper) {
        this.publisherRepo = publisherRepo;
        this.publisherMapper = publisherMapper;
    }

    public PublisherDTO create(PublisherDTO publisherDTO){
        Publisher publisher = publisherMapper.toEntity(publisherDTO);
        return publisherMapper.toDto(publisherRepo.save(publisher));
    }

    public List<PublisherDTO> getAll(){
        return publisherRepo.findAll().stream().map(publisherMapper::toDto).collect(Collectors.toList());
    }

    public Publisher getPublisherById(Long id){
        return publisherRepo.findById(id).orElseThrow(() -> new CustomException("Publisher not Found with id " + id));
    }

//    public PublisherDTO getPublisherById(Long id){
//        return publisherRepo.findById(id).map(publisherMapper::toDto).orElse(null);
//    }

    public void deletePublisher(Long id){
        publisherRepo.deleteById(id);
    }

    public PublisherDTO updatePublisher(Long id, PublisherDTO publisherDTO) {
        Publisher publisher = publisherRepo.findById(id).orElseThrow(() -> new CustomException("Publisher not Found with id " + id));
        publisher.setName(publisherDTO.getName());
        publisher.setCountry(publisherDTO.getCountry());
        return publisherMapper.toDto(publisherRepo.save(publisher));
    }
}
