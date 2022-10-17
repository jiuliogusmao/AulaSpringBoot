package br.ufsc.cursofs.AulaSpringBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufsc.cursofs.AulaSpringBoot.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Query(value = "SELECT  * FROM cliente WHERE cliente.id NOT IN (SELECT pedido.cliente_id FROM PEDIDO)", 
				nativeQuery = true)
	public List<Cliente> findNoPedido();
	
	
	@Query(value = "SELECT  * FROM cliente WHERE cliente.nome LIKE %?1%", nativeQuery = true)
	public List<Cliente> findByNameFilter(String filter);

	
}
