package br.edu.cesmac.jobsapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.cesmac.jobsapi.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	List<Empresa> findByNome(String nome);
}
