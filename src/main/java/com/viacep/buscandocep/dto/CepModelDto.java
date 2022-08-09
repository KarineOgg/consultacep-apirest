package com.viacep.buscandocep.dto;

import com.viacep.buscandocep.model.CepModel;

import lombok.Getter;

@Getter
public class CepModelDto {
	
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;


	public CepModelDto(CepModel cm) {
		
		this.cep = cm.getCep();
		this.logradouro = cm.getLogradouro();
		this.complemento = cm.getComplemento();
		this.bairro = cm.getBairro();
		this.localidade = cm.getLocalidade();
		this.uf = cm.getUf();
		this.ibge = cm.getIbge();
		this.gia = cm.getGia();
		this.ddd = cm.getDdd();
		this.siafi = cm.getSiafi();

	}

}
