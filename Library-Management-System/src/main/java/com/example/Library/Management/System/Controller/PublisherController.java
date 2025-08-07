package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.DTO.PublisherDTO;
import com.example.Library.Management.System.Service.PublisherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    //Create a Publisher
    @PostMapping("/add")
    public PublisherDTO create(@RequestBody PublisherDTO publisherDTO){
        return publisherService.create(publisherDTO);
    }

    //Get All Publisher
    @GetMapping
    public List<PublisherDTO> getAll(){
        return publisherService.getAll();
    }

    //Get Publisher by id
    @GetMapping("/{id}")
    public PublisherDTO getPublisherById(@PathVariable Long id){
        return publisherService.getPublisherById(id);
    }

    //Delete Publisher by id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
         publisherService.deletePublisher(id);
    }

    //Update Publisher by id
    @PutMapping("/{id}")
    public PublisherDTO updatePublisher(@PathVariable Long id, @RequestBody PublisherDTO publisherDTO) {
        return publisherService.updatePublisher(id, publisherDTO);
    }
}
