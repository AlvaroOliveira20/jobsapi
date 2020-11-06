package br.edu.cesmac.jobsapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cesmac.jobsapi.domain.Pessoa;
import br.edu.cesmac.jobsapi.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> perquisarPorNome(String nome) {
		return pessoaRepository.findByNome(nome);
	}

	public Pessoa salvar(Pessoa pessoa) {
		Pessoa pessoaeCriada = pessoaRepository.save(pessoa);
		return pessoaeCriada;
	}

	public Pessoa atualizar(Pessoa pessoa) {
		Pessoa pessoaeAtualizada = pessoaRepository.save(pessoa);
		return pessoaeAtualizada;
	}

	public void deletarPorId(Long id) throws Exception {
		Pessoa pessoaExclusao = pessoaRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
		pessoaRepository.deleteById(id);
	}

	public Pessoa buscarPorId(Long id) throws Exception {
		return pessoaRepository.findById(id).orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
	}

	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

}