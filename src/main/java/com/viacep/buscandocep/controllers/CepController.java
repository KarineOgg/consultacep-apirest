package com.viacep.buscandocep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.viacep.buscandocep.model.CepModel;
import com.viacep.buscandocep.service.CepService;

@RestController
@RequestMapping("/cep")
public class CepController {

	@Autowired
	private CepService cepService;

	@ResponseBody
	@GetMapping(value = "/buscar/{cep}")
	public ResponseEntity<CepModel> buscar(@PathVariable("cep") String cep) {

		CepModel cepModel = cepService.buscar(cep);

		return new ResponseEntity<CepModel>(cepModel, HttpStatus.OK);

	}
}
