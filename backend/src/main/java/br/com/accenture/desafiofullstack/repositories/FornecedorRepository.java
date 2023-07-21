package br.com.accenture.desafiofullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.accenture.desafiofullstack.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
