package br.edu.cesmac.jobsapi.resources;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.cesmac.jobsapi.domain.Pessoa;
import br.edu.cesmac.jobsapi.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	@Autowired
	private PessoaService pessoasService;

	@GetMapping(params = "titulo")
	public List<Pessoa> pesquisarPorNome(@RequestParam String nome) {
		return pessoasService.perquisarPorNome(nome);
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Pessoa pessoa) {
		pessoasService.salvar(pessoa);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getPessoa_id())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public void atualizar(@RequestBody Pessoa pessoa) {
		pessoasService.atualizar(pessoa);
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long idPessoa) throws Exception {
		pessoasService.deletarPorId(idPessoa);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable("id") Long idPessoa) throws Exception {
		Pessoa pessoa = pessoasService.buscarPorId(idPessoa);
		return ResponseEntity.ok(pessoa);
	}

}