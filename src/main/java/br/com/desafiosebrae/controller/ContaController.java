package br.com.desafiosebrae.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiosebrae.dto.ContaDTO;
import br.com.desafiosebrae.model.Conta;
import br.com.desafiosebrae.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {
    
    @Autowired
    private ContaService contaService;

    @PostMapping
    public ResponseEntity<ContaDTO> create(@RequestBody @Valid ContaDTO contaDto){

        Conta conta = contaService.converterEmEntidade(contaDto);

        if(conta == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Conta contaSalva = contaService.salvar(conta);

        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.converterEmDTO(contaSalva));
    }
}
