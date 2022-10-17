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

import br.ufsc.cursofs.AulaSpringBoot.entities.Pedido;
import br.ufsc.cursofs.AulaSpringBoot.services.PedidoService;

@RestController
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping(value = "/pedidos/insertComplete")
	public ResponseEntity<Pedido> saveComplete(@RequestBody Pedido pedido){
		
		Pedido pedidoSaved = pedidoService.saveComplete(pedido);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/pedidos/{id}")
				.buildAndExpand(pedidoSaved.getId()).toUri();
		
		return ResponseEntity.created(uri).body(pedidoSaved);		
	}
	
	@PutMapping(value = "/pedidos/{id}")
	public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody Pedido pedido){
		Pedido pedidoAtualizado = pedidoService.update(id, pedido);
		return ResponseEntity.ok().body(pedidoAtualizado);
	}
	
	
	@DeleteMapping(value = "/pedidos/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		pedidoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/pedidos")
	public ResponseEntity<Pedido> save(@RequestBody Pedido pedido){
		Pedido pedidoSaved = pedidoService.save(pedido);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/pedidos/{id}")
				.buildAndExpand(pedidoSaved.getId()).toUri();
		
		return ResponseEntity.created(uri).body(pedidoSaved);		
	}
	
	@GetMapping(value = "/pedidos")
	public ResponseEntity<List<Pedido>> findAll(){
		
		List<Pedido> pedidos = pedidoService.findAll();		
		return ResponseEntity.ok().body(pedidos);		
	}
	
	@GetMapping(value = "/pedidos/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		
		Pedido p = pedidoService.findById(id);
		return ResponseEntity.ok().body(p);		
		
	}
	
	
	
	

}
