package br.ufsc.cursofs.AulaSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufsc.cursofs.AulaSpringBoot.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
