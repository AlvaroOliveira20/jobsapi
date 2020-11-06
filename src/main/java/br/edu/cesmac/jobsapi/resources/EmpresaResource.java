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

import br.edu.cesmac.jobsapi.domain.Empresa;
import br.edu.cesmac.jobsapi.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaResource {
	@Autowired
	private EmpresaService empresasService;

	@GetMapping(params = "titulo")
	public List<Empresa> pesquisarPorNome(@RequestParam String nome) {
		return empresasService.perquisarPorNome(nome);
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Empresa empresa) {
		empresasService.salvar(empresa);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empresa.getEmpresa_id())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public void atualizar(@RequestBody Empresa empresa) {
		empresasService.atualizar(empresa);
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long idEmpresa) throws Exception {
		empresasService.deletarPorId(idEmpresa);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Empresa> buscarPorId(@PathVariable("id") Long idEmpresa) throws Exception {
		Empresa empresa = empresasService.buscarPorId(idEmpresa);
		return ResponseEntity.ok(empresa);
	}

}