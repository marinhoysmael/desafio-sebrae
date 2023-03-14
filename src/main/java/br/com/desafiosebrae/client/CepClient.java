package br.com.desafiosebrae.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.desafiosebrae.dto.CepDTO;

@FeignClient(name = "cep", url = "http://viacep.com.br")
public interface CepClient {
    
    @RequestMapping(method = RequestMethod.GET, value = "/ws/{cep}/json/", consumes = "application/json")
    CepDTO buscarCep(@PathVariable("cep") String cep);
}
