package com.viacep.buscandocep.service;

import com.viacep.buscandocep.dto.CepModelDto;
import com.viacep.buscandocep.model.CepModel;
import com.viacep.buscandocep.resources.CepModelForm;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


@SpringBootTest
public class CepServiceTest {

	@InjectMocks
	private CepService cepService = new CepService();

	@Test
	void BuscarCepTest() {
		CepModel buscar = cepService.buscar("21910130");

		assertEquals("Rua Doutor Bernardino Gomes", buscar.getLogradouro());
		assertEquals("Bancários", buscar.getBairro());
		assertEquals("RJ", buscar.getUf());
	}

	@Test
	void testaBuscaListaCep() {
		CepModelForm cepModelForm = new CepModelForm();
		cepModelForm.setCeps(Arrays.asList("49030170"));
		List<CepModelDto> result = cepService.buscarLista(cepModelForm);
		assertEquals(1, result.size());
	}


	@Test
	void testaConsultaCepComErro() {

		assertThrows(IllegalArgumentException.class, () -> cepService.buscar(""));
	}

	@Test
	void testaConsultaListaVazia() {
		CepModelForm param = null;
		cepService.buscarLista(new CepModelForm());



	}


	public static void main(String[] args) {
		CepModelForm cmf = new CepModelForm();
		List<String> ceps = new ArrayList<>();

		ceps.add("49030170");
		cmf.setCeps(ceps);
		System.out.println(ceps);

	}
}




