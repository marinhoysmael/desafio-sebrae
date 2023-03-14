package br.com.desafiosebrae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiosebrae.dto.CepDTO;
import br.com.desafiosebrae.service.CepService;

@RestController
public class CepController {
    
    @Autowired
    private CepService cepService;
    
    @GetMapping("/{cep}")
    public ResponseEntity<CepDTO> buscarCEP(@PathVariable String cep){
        
        CepDTO cepDTO = cepService.buscarCep(cep);

        if(cepDTO == null) {
            return ResponseEntity.notFound().build();
		}
		
        return ResponseEntity.ok(cepDTO);
    }
}
