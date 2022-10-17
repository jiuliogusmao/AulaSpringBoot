package br.ufsc.cursofs.AulaSpringBoot.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufsc.cursofs.AulaSpringBoot.entities.Endereco;
import br.ufsc.cursofs.AulaSpringBoot.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository; 
	
	
	public Endereco update(Long id, Endereco endereco) {
		
		Endereco enderecoEntity = enderecoRepository.getReferenceById(id);
		
		enderecoEntity.setTipo(endereco.getTipo());
		enderecoEntity.setRua(endereco.getRua());
		enderecoEntity.setNumero(endereco.getNumero());
		enderecoEntity.setCep(endereco.getCep());
		
		return enderecoRepository.save(enderecoEntity);		
	}
	
	
	public void deleteById(Long id) {
		enderecoRepository.deleteById(id);
	}
	
	
	public Endereco save(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public List<Endereco> findAll(){
		return enderecoRepository.findAll();
	}

	public Endereco findById(Long id) {		
		try {
			return enderecoRepository.findById(id).get();
		} catch(NoSuchElementException e) {
			throw new EntityNotFoundException("EntityNotFoundException Endereco id: " + id);
		}
	}
	
}
