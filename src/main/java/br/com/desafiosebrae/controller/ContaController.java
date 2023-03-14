package br.com.desafiosebrae.controller;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiosebrae.dto.ContaDTO;
import br.com.desafiosebrae.model.Conta;
import br.com.desafiosebrae.service.ContaService;
import liquibase.repackaged.org.apache.commons.lang3.StringUtils;

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
    
    @GetMapping("/{nome}")
	public ResponseEntity<ContaDTO> reader(@PathVariable String nome) {
		
		Optional<Conta> contaOption = contaService.buscarPorNome(nome);
		
		if(contaOption.isPresent()) {
			return ResponseEntity.ok(contaService.converterEmDTO(contaOption.get()));
		}
		
		return ResponseEntity.notFound().build();
		
	}

    @PutMapping("/{nome}")
    public ResponseEntity<ContaDTO> update(@PathVariable String nome, @RequestBody String descricao){
        
        Optional<Conta> contaOptional = contaService.buscarPorNome(nome);

        if(!contaOptional.isPresent()) {
			return  ResponseEntity.notFound().build();
		}
        Conta conta = contaOptional.get();


        if(StringUtils.isEmpty(descricao)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        conta.setDescricao(descricao);

        Conta contaSalva = contaService.salvar(conta);

        return ResponseEntity.status(HttpStatus.OK).body(contaService.converterEmDTO(contaSalva));

    }


    @DeleteMapping("/{nome}")
	public ResponseEntity<?> remover(@PathVariable String nome){
        
        Optional<Conta> contaOptional = contaService.buscarPorNome(nome);

        if(!contaOptional.isPresent()) {
			return  ResponseEntity.notFound().build();
		}
		
        contaService.deletar(contaOptional.get());
		
        return ResponseEntity.ok().build();
		
		
	}


}
