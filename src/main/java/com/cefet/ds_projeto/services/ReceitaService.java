package com.cefet.ds_projeto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cefet.ds_projeto.dto.ReceitaDTO;
import com.cefet.ds_projeto.entities.Receita;
import com.cefet.ds_projeto.repositories.ReceitaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReceitaService {
    @Autowired
	private ReceitaRepository receitaRepository;


	public List<ReceitaDTO> findAll(){
	List<Receita> listaReceitas = receitaRepository.findAll();
	return listaReceitas.stream().map(ReceitaDTO::new).toList();
	}
	
	public ReceitaDTO findById(Long id) {
		Receita receita = receitaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Receita não encontrada com ID: " + id));
		return new ReceitaDTO(receita);
	}
	
	public ReceitaDTO insert(ReceitaDTO receitaDTO) {

	
	Receita receita = new Receita();
    receita.setDataEntrada(receitaDTO.getDataEntrada());
    receita.setValor(receitaDTO.getValor());
	receita.setCategoria(receitaDTO.getCategoria());
    receita.setUsuario(receitaDTO.getUsuario());
	Receita receitaSalvo = receitaRepository.save(receita);
	return new ReceitaDTO(receitaSalvo);
	} 
	
	public ReceitaDTO update(Long id, ReceitaDTO receitaDTO) {
		Receita receita = receitaRepository.findById(id)
		.orElseThrow(() -> new EntityNotFoundException("Receita não encontrada com ID: " + id));
		
        receita.setDataEntrada(receitaDTO.getDataEntrada());
        receita.setValor(receitaDTO.getValor());
		receita.setCategoria(receitaDTO.getCategoria());
		receita.setUsuario(receitaDTO.getUsuario());
		
		Receita receitaAtualizado = receitaRepository.save(receita);
		return new ReceitaDTO(receitaAtualizado);
		}
	
	public void delete(Long id) {
		if(!receitaRepository.existsById(id)) {
			throw new EntityNotFoundException("Usuário não encontrado com ID " + id);
		}
		receitaRepository.deleteById(id);
	} 
	}