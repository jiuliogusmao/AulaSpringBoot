package br.ufsc.cursofs.AulaSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufsc.cursofs.AulaSpringBoot.entities.PedidoProduto;
import br.ufsc.cursofs.AulaSpringBoot.entities.PedidoProduto.IdPk;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, IdPk>{
	
}
