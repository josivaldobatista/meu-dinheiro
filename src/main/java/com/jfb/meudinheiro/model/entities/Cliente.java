package com.jfb.meudinheiro.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data // <- Lombok
@NoArgsConstructor // <- Lombok: Criar o construtor sem argumentos.
@AllArgsConstructor // <- Lombok: Criar o construtor com argumentos.
@Builder // <- Lombok: Para ter um builder de cliente.
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

    @PrePersist // Anotação para fazer alguma coisa antes de persistir os dados.
    public void prePersist() {
        setDataCadastro(LocalDate.now());
    }

}
