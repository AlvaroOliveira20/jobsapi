package br.edu.cesmac.jobsapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cesmac.jobsapi.domain.Habilidade;
import br.edu.cesmac.jobsapi.repository.HabilidadeRepository;

@Service
public class HabilidadeService {

	@Autowired
	private HabilidadeRepository habilidadeRepository;

	public List<Habilidade> perquisarPorNome(String nome) {
		return habilidadeRepository.findByNome(nome);
	}

	public Habilidade salvar(Habilidade habilidade) {
		Habilidade habilidadeeCriada = habilidadeRepository.save(habilidade);
		return habilidadeeCriada;
	}

	public Habilidade atualizar(Habilidade habilidade) {
		Habilidade habilidadeeAtualizada = habilidadeRepository.save(habilidade);
		return habilidadeeAtualizada;
	}

	public void deletarPorId(Long id) throws Exception {
		Habilidade habilidadeExclusao = habilidadeRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
		habilidadeRepository.deleteById(id);
	}

	public Habilidade buscarPorId(Long id) throws Exception {
		return habilidadeRepository.findById(id).orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
	}

	public List<Habilidade> listar() {
		return habilidadeRepository.findAll();
	}

}