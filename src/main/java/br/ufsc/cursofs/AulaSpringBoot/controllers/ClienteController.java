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

import br.ufsc.cursofs.AulaSpringBoot.entities.Cliente;
import br.ufsc.cursofs.AulaSpringBoot.services.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/clientes/findByNameFilter/{filter}")
	public ResponseEntity<List<Cliente>> findNoPedido(@PathVariable String filter){
		
		List<Cliente> clientes = clienteService.findByNameFilter(filter);		
		return ResponseEntity.ok().body(clientes);		
	}
	
		
	@GetMapping(value = "/clientes/noPedido")
	public ResponseEntity<List<Cliente>> findNoPedido(){
		
		List<Cliente> clientes = clienteService.findNoPedido();		
		return ResponseEntity.ok().body(clientes);		
	}
	
	@GetMapping(value = "/clientes/{id_cliente}/addEndereco/{id_endereco}")
	public ResponseEntity<Cliente> addEndereco(@PathVariable Long id_cliente, 
			@PathVariable Long id_endereco){
		Cliente cliente = clienteService.addEndereco(id_cliente, id_endereco);
		
		return ResponseEntity.ok().body(cliente); 
	}
	
	@DeleteMapping(value = "/clientes/{id_cliente}/removeEndereco/{id_endereco}")
	public ResponseEntity<Cliente> removeEndereco(@PathVariable Long id_cliente, 
			@PathVariable Long id_endereco){
		Cliente cliente = clienteService.removeEndereco(id_cliente, id_endereco);
		
		return ResponseEntity.ok().body(cliente); 
	}
	
	
	@PutMapping(value = "/clientes/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente){
		Cliente clienteAtualizado = clienteService.update(id, cliente);
		return ResponseEntity.ok().body(clienteAtualizado);
	}
	
	
	@DeleteMapping(value = "/clientes/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		clienteService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/clientes")
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
		Cliente clienteSaved = clienteService.save(cliente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/clientes/{id}")
				.buildAndExpand(clienteSaved.getId()).toUri();
		
		return ResponseEntity.created(uri).body(clienteSaved);		
	}
	
	@GetMapping(value = "/clientes")
	public ResponseEntity<List<Cliente>> findAll(){
		
		List<Cliente> clientes = clienteService.findAll();		
		return ResponseEntity.ok().body(clientes);		
	}
	
	@GetMapping(value = "/clientes/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		
		Cliente c = clienteService.findById(id);
		return ResponseEntity.ok().body(c);		
		
	}
	
	
	
	

}
