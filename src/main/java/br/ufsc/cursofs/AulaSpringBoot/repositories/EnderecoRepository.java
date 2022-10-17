package br.ufsc.cursofs.AulaSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufsc.cursofs.AulaSpringBoot.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
}
