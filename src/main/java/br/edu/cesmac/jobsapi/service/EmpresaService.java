package br.edu.cesmac.jobsapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cesmac.jobsapi.domain.Empresa;
import br.edu.cesmac.jobsapi.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaesRepository;

	public List<Empresa> perquisarPorNome(String nome) {
		return empresaesRepository.findByNome(nome);
	}

	public Empresa salvar(Empresa empresa) {
		Empresa empresaeCriada = empresaesRepository.save(empresa);
		return empresaeCriada;
	}

	public Empresa atualizar(Empresa empresa) {
		Empresa empresaeAtualizada = empresaesRepository.save(empresa);
		return empresaeAtualizada;
	}

	public void deletarPorId(Long id) throws Exception {
		Empresa empresaExclusao = empresaesRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
		empresaesRepository.deleteById(id);
	}

	public Empresa buscarPorId(Long id) throws Exception {
		return empresaesRepository.findById(id).orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
	}

	public List<Empresa> listar() {
		return empresaesRepository.findAll();
	}

}