package com.viacep.buscandocep.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.viacep.buscandocep.dto.CepModelDto;
import com.viacep.buscandocep.model.CepModel;
import com.viacep.buscandocep.resources.CepModelForm;


@Service
public class CepService {

	public CepModel buscar(String cep) {
		if (cep.isEmpty()) {
			throw new IllegalArgumentException("Um cep precisa ser informado");
		}
		return new RestTemplate().getForEntity("https://viacep.com.br/ws/" + cep + "/json", CepModel.class).getBody();
	}
	
	public List<CepModelDto> buscarLista(CepModelForm cepModelform) {

		List<String> ceps = cepModelform.getCeps();
		List<CepModelDto> lsCepModelDto = new ArrayList<>();
		ceps.forEach(cep -> {
			CepModel cepModel = buscar(cep);
			CepModelDto endereco = new CepModelDto(cepModel);
			lsCepModelDto.add(endereco);
		});
		return lsCepModelDto;
	}
}
