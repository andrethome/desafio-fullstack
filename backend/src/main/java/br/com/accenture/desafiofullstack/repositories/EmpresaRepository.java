package br.com.accenture.desafiofullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.accenture.desafiofullstack.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
