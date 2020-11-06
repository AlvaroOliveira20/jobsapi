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

import br.edu.cesmac.jobsapi.domain.Habilidade;
import br.edu.cesmac.jobsapi.service.HabilidadeService;

@RestController
@RequestMapping("/habilidades")
public class HabilidadeResource {
	@Autowired
	private HabilidadeService habilidadesService;

	@GetMapping(params = "titulo")
	public List<Habilidade> pesquisarPorNome(@RequestParam String nome) {
		return habilidadesService.perquisarPorNome(nome);
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Habilidade habilidade) {
		habilidadesService.salvar(habilidade);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(habilidade.getHabilidade_id())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public void atualizar(@RequestBody Habilidade habilidade) {
		habilidadesService.atualizar(habilidade);
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long idHabilidade) throws Exception {
		habilidadesService.deletarPorId(idHabilidade);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Habilidade> buscarPorId(@PathVariable("id") Long idHabilidade) throws Exception {
		Habilidade habilidade = habilidadesService.buscarPorId(idHabilidade);
		return ResponseEntity.ok(habilidade);
	}

}