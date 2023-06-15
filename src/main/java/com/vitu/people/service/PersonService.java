package com.vitu.people.service;

import com.vitu.people.dtos.request.PersonRequestDTO;
import com.vitu.people.dtos.response.PersonResponseDTO;

import java.util.List;

public interface PersonService {
    PersonResponseDTO findById(Long id);
    List<PersonResponseDTO> findAll();
    PersonResponseDTO register(PersonRequestDTO personRequestDTO);
    PersonResponseDTO update(PersonRequestDTO personRequestDTO, Long id);
    String delete(Long id);
}
