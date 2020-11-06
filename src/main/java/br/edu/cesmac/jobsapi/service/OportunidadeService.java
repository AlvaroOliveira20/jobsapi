package br.edu.cesmac.jobsapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cesmac.jobsapi.domain.Oportunidade;
import br.edu.cesmac.jobsapi.repository.OportunidadeRepository;

@Service
public class OportunidadeService {

	@Autowired
	private OportunidadeRepository oportunidadeRepository;

	public List<Oportunidade> perquisarPorNome(String nome) {
		return oportunidadeRepository.findByNome(nome);
	}

	public Oportunidade salvar(Oportunidade oportunidade) {
		Oportunidade oportunidadeeCriada = oportunidadeRepository.save(oportunidade);
		return oportunidadeeCriada;
	}

	public Oportunidade atualizar(Oportunidade oportunidade) {
		Oportunidade oportunidadeeAtualizada = oportunidadeRepository.save(oportunidade);
		return oportunidadeeAtualizada;
	}

	public void deletarPorId(Long id) throws Exception {
		Oportunidade oportunidadeExclusao = oportunidadeRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
		oportunidadeRepository.deleteById(id);
	}

	public Oportunidade buscarPorId(Long id) throws Exception {
		return oportunidadeRepository.findById(id).orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
	}

	public List<Oportunidade> listar() {
		return oportunidadeRepository.findAll();
	}

}