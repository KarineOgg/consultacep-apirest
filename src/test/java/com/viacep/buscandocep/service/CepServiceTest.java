package com.viacep.buscandocep.service;

import com.viacep.buscandocep.dto.CepModelDto;
import com.viacep.buscandocep.model.CepModel;
import com.viacep.buscandocep.resources.CepModelForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThrows;


@SpringBootTest
 class CepServiceTest {

	@InjectMocks
	private CepService cepService = new CepService();

	@Test
	void deveBuscarCepTest() {
		CepModel buscar = cepService.buscar("21910130");

		Assertions.assertEquals("Rua Doutor Bernardino Gomes", buscar.getLogradouro());

	}
	@Test
	void testarConsultaCepComErro() {

		assertThrows(IllegalArgumentException.class, () -> cepService.buscar(""));
	}
	@Test
	void  testarLimiteString() {

		assertThrows(RuntimeException.class, () -> cepService.buscar("219101301"));
	}
	@Test
	void testarCaracterDiferente() {

	}

	@Test
	void deveTestarBuscaListaCep() {
		CepModelForm cepModelForm = new CepModelForm();
		cepModelForm.setCeps(Arrays.asList("26587110"));
		List<CepModelDto> result = cepService.buscarLista(cepModelForm);
		Assertions.assertEquals(1, result.size());
	}


	@Test
	void testaConsultaListaVazia() {

	assertThrows(NullPointerException.class, () -> cepService.buscarLista(null));



	}

	


}





