package com.cefet.ds_projeto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cefet.ds_projeto.dto.ReceitaDTO;
import com.cefet.ds_projeto.services.ReceitaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/receitas")

public class ReceitaControlller {
    @Autowired
	private ReceitaService receitaService;
	
	
	@GetMapping("/{id}")
	@Operation(summary = "Buscar despesa por ID", description = "Retorna os dados de uma receita específica com base no seu ID.")
	public ResponseEntity<ReceitaDTO> findById(
		@Parameter(description = "ID da receita", example = "2")
		@PathVariable Long id) {
	ReceitaDTO receitaDTO = receitaService.findById(id);
	return ResponseEntity.ok(receitaDTO);
	}
	
	@GetMapping
	@Operation(summary = "Listar todas as receitas", description = "Retorna todas as receitas cadastradas no sistema.")
	public ResponseEntity<List<ReceitaDTO>> findAll() {
	List<ReceitaDTO> receitasDTOs = receitaService.findAll();
	return ResponseEntity.ok(receitasDTOs);
	}
	
	@PostMapping
	@Operation(summary = "Cadastrar nova receita", description = "Cria uma nova receita no sistema.")
	public ResponseEntity<ReceitaDTO> create(@RequestBody ReceitaDTO receitaDTO) {
	ReceitaDTO novoReceita = receitaService.insert(receitaDTO);
	return ResponseEntity.status(201).body(novoReceita);
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Atualizar receita", description = "Atualiza os dados de uma receita existente com base no ID.")
	public ResponseEntity<ReceitaDTO> update(
		@Parameter(description = "ID da receita a ser atualizada", example = "10")
		@PathVariable Long id,
		@Parameter(description = "Novos dados da receita") 
		@RequestBody ReceitaDTO receitaDTO) {
	ReceitaDTO receitaAtualizado = receitaService.update(id, receitaDTO);
	return ResponseEntity.ok(receitaAtualizado);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Excluir receita", description = "Remove uma receita do sistema com base no ID.")
	public ResponseEntity<Void> delete(
		@Parameter(description = "ID da receita a ser excluída", example = "10")
		@PathVariable Long id) {
	receitaService.delete(id);
	return ResponseEntity.noContent().build();
	}
}
	