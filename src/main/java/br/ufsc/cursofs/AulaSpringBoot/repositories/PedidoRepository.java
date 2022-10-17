package br.ufsc.cursofs.AulaSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufsc.cursofs.AulaSpringBoot.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
}
