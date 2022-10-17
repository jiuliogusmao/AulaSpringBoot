package br.ufsc.cursofs.AulaSpringBoot.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ufsc.cursofs.AulaSpringBoot.entities.Endereco;
import br.ufsc.cursofs.AulaSpringBoot.services.EnderecoService;

@RestController
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@PutMapping(value = "/enderecos/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco endereco){
		Endereco enderecoAtualizado = enderecoService.update(id, endereco);
		return ResponseEntity.ok().body(enderecoAtualizado);
	}
	
	
	@DeleteMapping(value = "/enderecos/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		enderecoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/enderecos")
	public ResponseEntity<Endereco> save(@RequestBody Endereco endereco){
		Endereco enderecoSaved = enderecoService.save(endereco);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/enderecos/{id}")
				.buildAndExpand(enderecoSaved.getId()).toUri();
		
		return ResponseEntity.created(uri).body(enderecoSaved);		
	}
	
	@GetMapping(value = "/enderecos")
	public ResponseEntity<List<Endereco>> findAll(){
		
		List<Endereco> enderecos = enderecoService.findAll();		
		return ResponseEntity.ok().body(enderecos);		
	}
	
	@GetMapping(value = "/enderecos/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id){
		
		Endereco c = enderecoService.findById(id);
		return ResponseEntity.ok().body(c);		
		
	}
	
	
	
	

}
