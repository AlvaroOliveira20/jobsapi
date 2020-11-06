package br.edu.cesmac.jobsapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.cesmac.jobsapi.domain.Habilidade;

@Repository
public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {
	List<Habilidade> findByNome(String nome);
}
