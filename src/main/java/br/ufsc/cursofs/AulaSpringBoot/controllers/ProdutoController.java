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

import br.ufsc.cursofs.AulaSpringBoot.entities.Produto;
import br.ufsc.cursofs.AulaSpringBoot.services.ProdutoService;

@RestController
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	
	@PutMapping(value = "/produtos/{id_produto}/addCategoria/{id_categoria}")
	public ResponseEntity<Produto> addEndereco(@PathVariable Long id_produto, 
			@PathVariable Long id_categoria){
		Produto produto = produtoService.addCategoria(id_produto, id_categoria);
		
		return ResponseEntity.ok().body(produto); 
	}
	
	@DeleteMapping(value = "/produtos/{id_produto}/removeCategoria/{id_categoria}")
	public ResponseEntity<Produto> removeEndereco(@PathVariable Long id_produto, 
			@PathVariable Long id_categoria){
		Produto produto = produtoService.removeCategoria(id_produto, id_categoria);
		
		return ResponseEntity.ok().body(produto); 
	}
	
	@PutMapping(value = "/produtos/{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
		Produto produtoAtualizado = produtoService.update(id, produto);
		return ResponseEntity.ok().body(produtoAtualizado);
	}
	
	
	@DeleteMapping(value = "/produtos/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		produtoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PostMapping(value = "/produtos/insertMany")
	public ResponseEntity<List<Produto>> saveMany(@RequestBody List<Produto> produtos){
		
		List<Produto> produtosSaved = produtoService.saveMany(produtos);
		
		return ResponseEntity.ok().body(produtosSaved);		
	}

	
	
	@PostMapping(value = "/produtos")
	public ResponseEntity<Produto> save(@RequestBody Produto produto){
		Produto produtoSaved = produtoService.save(produto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produtos/{id}")
				.buildAndExpand(produtoSaved.getId()).toUri();
		
		return ResponseEntity.created(uri).body(produtoSaved);		
	}
	
	@GetMapping(value = "/produtos")
	public ResponseEntity<List<Produto>> findAll(){
		
		List<Produto> produtos = produtoService.findAll();		
		return ResponseEntity.ok().body(produtos);		
	}
	
	@GetMapping(value = "/produtos/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		
		Produto c = produtoService.findById(id);
		return ResponseEntity.ok().body(c);		
		
	}
	
	
	
	

}
