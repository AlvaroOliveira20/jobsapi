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

import br.edu.cesmac.jobsapi.domain.Oportunidade;
import br.edu.cesmac.jobsapi.service.OportunidadeService;

@RestController
@RequestMapping("/oportunidades")
public class OportunidadeResource {
	@Autowired
	private OportunidadeService oportunidadesService;

	@GetMapping(params = "titulo")
	public List<Oportunidade> pesquisarPorNome(@RequestParam String nome) {
		return oportunidadesService.perquisarPorNome(nome);
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Oportunidade oportunidade) {
		oportunidadesService.salvar(oportunidade);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(oportunidade.getOportunidade_id())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public void atualizar(@RequestBody Oportunidade oportunidade) {
		oportunidadesService.atualizar(oportunidade);
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long idOportunidade) throws Exception {
		oportunidadesService.deletarPorId(idOportunidade);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Oportunidade> buscarPorId(@PathVariable("id") Long idOportunidade) throws Exception {
		Oportunidade oportunidade = oportunidadesService.buscarPorId(idOportunidade);
		return ResponseEntity.ok(oportunidade);
	}

}