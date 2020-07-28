package com.jfb.meudinheiro.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data // <- Lombok
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

}
