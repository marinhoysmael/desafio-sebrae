package br.com.desafiosebrae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafiosebrae.client.CepClient;
import br.com.desafiosebrae.dto.CepDTO;

@Service
public class CepService {

    @Autowired
    private CepClient cepClient;
    
    public CepDTO buscarCep(String cep){
        
        return cepClient.buscarCep(cep);
    }
}
