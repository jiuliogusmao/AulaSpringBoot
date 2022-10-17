package br.ufsc.cursofs.AulaSpringBoot.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufsc.cursofs.AulaSpringBoot.entities.Pedido;
import br.ufsc.cursofs.AulaSpringBoot.entities.PedidoProduto;
import br.ufsc.cursofs.AulaSpringBoot.repositories.PedidoProdutoRepository;
import br.ufsc.cursofs.AulaSpringBoot.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository; 
	
	@Autowired
	private PedidoProdutoRepository pedidoProdutoRepository;
	
	
	public Pedido update(Long id, Pedido pedido) {
		Pedido pedidoEntity = pedidoRepository.getReferenceById(id);
		
		pedidoEntity.setData(pedido.getData());
		
		return pedidoRepository.save(pedidoEntity);		
	}
	
	
	public void deleteById(Long id) {
		//try {
			pedidoRepository.deleteById(id);
		//}catch (RuntimeException e) {
		//	e.printStackTrace();
		//}
		
	}
	
	
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}

	public Pedido findById(Long id) {		
		try {
			return pedidoRepository.findById(id).get();
		} catch(NoSuchElementException e) {
			throw new EntityNotFoundException("EntityNotFoundException Pedido id: " + id);
		}
	}


	public Pedido saveComplete(Pedido pedido) {
				
		// salvar o pedido (cabeçalho)
		Pedido savedPedido = pedidoRepository.save(pedido);
		
		// informar qual é o pedido de cada Produto
		for (PedidoProduto pp: pedido.getProdutos()) {
			pp.setPedido(savedPedido);
		}
		
		// salvar os produtos
		pedidoProdutoRepository.saveAll(pedido.getProdutos());
		
		return findById(savedPedido.getId());
		
	}
	
}
