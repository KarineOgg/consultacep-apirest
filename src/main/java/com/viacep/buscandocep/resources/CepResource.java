package com.viacep.buscandocep.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viacep.buscandocep.dto.CepModelDto;
import com.viacep.buscandocep.model.CepModel;
import com.viacep.buscandocep.service.CepService;

@RestController
@RequestMapping("/api")
public class CepResource {

	@Autowired
	private CepService cepService;

	@GetMapping(value = "/buscar/{cep}")
	public ResponseEntity<CepModelDto> buscar(@PathVariable("cep") String cep) {

		CepModel cepModel = cepService.buscar(cep);
		CepModelDto dto = new CepModelDto(cepModel);
		
		return ResponseEntity.ok(dto);

	}
	@PostMapping("/cep")
	public ResponseEntity<List<CepModelDto>> buscarLista(
			@RequestBody CepModelForm cepModelForm) {
		
		List<CepModelDto> lsCeps = cepService.buscarLista(cepModelForm);
		return ResponseEntity.ok().body(lsCeps);
	}
}
