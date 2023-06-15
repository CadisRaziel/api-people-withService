package com.vitu.people.service;

import com.vitu.people.dtos.request.PersonRequestDTO;
import com.vitu.people.dtos.response.PersonResponseDTO;
import com.vitu.people.model.Person;
import com.vitu.people.repository.PersonRepository;
import com.vitu.people.util.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public PersonResponseDTO findById(Long id) {
        //metodo para encontrar pelo id do usuario
        //vai ser feito um tratamento de conversão de Person para PersonResponseDTO e sera retornado o dto
       return personMapper.toPersonDTO(returnPersonById(id));
    }

    @Override
    public List<PersonResponseDTO> findAll() {
        //metodo para encontrar todos os usuarios
        //vai ser feito um tratamento de conversão de Person para PersonResponseDTO e sera retornado o dto
        return personMapper.toPersonListDTO(personRepository.findAll());
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personRequestDTO) {
        //metodo para registrar um usuario
        Person person = personMapper.toPerson(personRequestDTO);

        //depois de registrado convertemos o person para um personDto para ser retornado
        return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public PersonResponseDTO update(PersonRequestDTO personRequestDTO, Long id) {
        //recuperando a pessoa pelo id
        Person person = returnPersonById(id);

        //atualizando os dados da pessoa
        personMapper.updatePersonData(person, personRequestDTO);

        //salvar as atualizações no banco
        return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public String delete(Long id) {
        personRepository.deleteById(id);
        return "Person " + id + " deleted successfully";
    }

    //Metodo auxiliar pois o findById e o update usam o mesmo codigo (findById)
    private Person returnPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("The person was not found in the database"));
    }
}
