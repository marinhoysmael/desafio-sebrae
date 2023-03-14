package br.com.desafiosebrae.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.desafiosebrae.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, String>{
    
}
