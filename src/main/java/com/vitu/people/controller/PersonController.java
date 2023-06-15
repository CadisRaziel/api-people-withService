package com.vitu.people.controller;

import com.vitu.people.dtos.request.PersonRequestDTO;
import com.vitu.people.dtos.response.PersonResponseDTO;
import com.vitu.people.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(personService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonResponseDTO>> findAll(){
        return ResponseEntity.ok().body(personService.findAll());
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> register(@RequestBody PersonRequestDTO personRequestDTO, UriComponentsBuilder uriBuilder){
        PersonResponseDTO personResponseDTO = personService.register(personRequestDTO);
        URI uri = uriBuilder.path("/api/v1/people/{id}").buildAndExpand(personResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(personResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDTO> update(@RequestBody PersonRequestDTO personRequestDTO, @PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(personService.update(personRequestDTO, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(personService.delete(id));
    }
}
