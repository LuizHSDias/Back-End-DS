package com.cefet.ds_projeto.dto;

import java.time.LocalDate;

import com.cefet.ds_projeto.entities.Categoria;
import com.cefet.ds_projeto.entities.Receita;
import com.cefet.ds_projeto.entities.Usuario;

import io.swagger.v3.oas.annotations.media.Schema; 

@Schema(description = "DTO para representar uma receita (entrada de valor)")

public class ReceitaDTO {

    @Schema(description = "ID único da receita", example = "1")
    private Long id;

    @Schema(description = "Data em que a receita foi registrada", example = "2024-06-27")
    private LocalDate dataEntrada;

    @Schema(description = "Valor da receita", example = "1500.75")
    private Double valor;

    @Schema(description = "ID da categoria associada a esta receita", example = "101")
    private Categoria categoria;

    @Schema(description = "ID do usuário que registrou a receita", example = "201")
    private Usuario usuario;

    public ReceitaDTO() {
    }

    public ReceitaDTO(Receita receita) {
        this.id = receita.getId();
        this.dataEntrada = receita.getDataEntrada();
        this.valor = receita.getValor();
        this.categoria = receita.getCategoria();
        this.usuario = receita.getUsuario();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    
    public Double getValor() {
        return valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}