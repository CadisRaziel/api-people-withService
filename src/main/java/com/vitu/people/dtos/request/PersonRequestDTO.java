package com.vitu.people.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter //-> biblioteca do lombok para gerar automatico sem eu precisar fazer ali em baixo
@Setter //-> biblioteca do lombok para gerar automatico sem eu precisar fazer ali em baixo
public class PersonRequestDTO {

    //request -> dados que o usuario esta enviado do client para a api

    private String name;

    private String cpf;

    private Integer age;

}
