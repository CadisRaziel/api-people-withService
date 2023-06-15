package com.vitu.people.dtos.response;

import com.vitu.people.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter //-> biblioteca do lombok para gerar automatico sem eu precisar fazer ali em baixo
@Setter //-> biblioteca do lombok para gerar automatico sem eu precisar fazer ali em baixo
public class PersonResponseDTO {
    //response -> dados que a api esta enviado para o client
    private Long id;

    private String name;

    private String cpf;

    private Integer age;

    public PersonResponseDTO(Person person) {
        //convertendo o dto para a entidade person
        this.id = person.getId();
        this.name = person.getName();
        this.cpf = person.getCpf();
        this.age = person.getAge();    }

}
