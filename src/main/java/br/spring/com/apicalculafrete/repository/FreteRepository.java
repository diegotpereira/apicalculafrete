package br.spring.com.apicalculafrete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.spring.com.apicalculafrete.model.Frete;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long>{
	
}
