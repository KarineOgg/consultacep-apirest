package com.viacep.buscandocep.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.viacep.buscandocep.model.CepModel;

@Service
public class CepService {

	public CepModel buscar(String cep) {

		return new RestTemplate().getForEntity("https://viacep.com.br/ws/" + cep + "/json", CepModel.class).getBody();

	}

}
