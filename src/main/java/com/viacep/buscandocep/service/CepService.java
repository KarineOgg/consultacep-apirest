package com.viacep.buscandocep.service;

import com.viacep.buscandocep.dto.CepModelDto;
import com.viacep.buscandocep.model.CepModel;
import com.viacep.buscandocep.resources.CepModelForm;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class CepService {

    public CepModel buscar(String cep) {

        verificaValidadeCep(cep);
        return new RestTemplate().getForEntity("https://viacep.com.br/ws/" + cep + "/json", CepModel.class).getBody();
    }

    private void verificaValidadeCep(String cep) {
        if (cep.isEmpty()) {
            throw new IllegalArgumentException("Um cep precisa ser informado");
        }

        if (!cep.matches("[0-9]{8}")) {
            throw new IllegalArgumentException("CEP inválido.");
        }
    }

    public List<CepModelDto> buscarLista(CepModelForm cepModelform) {
        if (cepModelform.getCeps() == null) {
            throw new RuntimeException("Lista nula");
        }

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
