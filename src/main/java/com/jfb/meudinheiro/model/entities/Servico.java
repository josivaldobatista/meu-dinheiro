package com.jfb.meudinheiro.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data // <- Lombok
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 155)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column
    private BigDecimal valor;
}
