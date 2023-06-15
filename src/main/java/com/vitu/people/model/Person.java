package com.vitu.people.model;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Person")// -> posso nomear a entidade (vai se representada na tabela com o nome "Remedio"
@Table(name = "tb_person")
@Getter //-> biblioteca do lombok para gerar automatico sem eu precisar fazer ali em baixo
@Setter //-> biblioteca do lombok para gerar automatico sem eu precisar fazer ali em baixo
@NoArgsConstructor //-> biblioteca do lombok para gerar automatico sem eu precisar fazer ali em baixo (construtor vazio)
@EqualsAndHashCode(of = "id")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    //@Getter(AccessLevel.NONE) //-> ninguem vai poder alterar esse valor !!
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Builder
    public Person(String name, String cpf, Integer age) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }


}
