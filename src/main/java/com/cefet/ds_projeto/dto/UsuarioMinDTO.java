package com.cefet.ds_projeto.dto;

import com.cefet.ds_projeto.entities.Usuario;

public class UsuarioMinDTO {
    private Long id;
	private String nome;
    private String email;

	public UsuarioMinDTO() {
	}

	public UsuarioMinDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
        this.email = usuario.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

    public String getEmail() {
		return email;
	}
}
