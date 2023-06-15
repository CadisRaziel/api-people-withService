package com.vitu.people.util;

import com.vitu.people.dtos.request.PersonRequestDTO;
import com.vitu.people.dtos.response.PersonResponseDTO;
import com.vitu.people.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    //Classe criada para transformar o Person em PersonResponseDTO e vice-versa
    //Evita a criação de varios maps no service

    public Person toPerson(PersonRequestDTO personRequestDTO){
        //transformando o PersonRequestDTO em Person
        return Person.builder()
                .name(personRequestDTO.getName())
                .cpf(personRequestDTO.getCpf())
                .age(personRequestDTO.getAge())
                .build();
    }

    public PersonResponseDTO toPersonDTO(Person person){
        //transformando o Person em PersonResponseDTO
        return new PersonResponseDTO(person);
    }

    public List<PersonResponseDTO> toPersonListDTO(List<Person> peopleList){
        //transformando a lista de Person em lista de PersonResponseDTO (stream e map)
        return peopleList.stream().map(PersonResponseDTO::new).collect(Collectors.toList());
    }

    public void updatePersonData(Person person, PersonRequestDTO personRequestDTO) {
        //atualizando os dados do person
        person.setName(personRequestDTO.getName());
        person.setCpf(personRequestDTO.getCpf());
        person.setAge(personRequestDTO.getAge());
    }
}
