package br.com.desafiosebrae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafiosebrae.model.Conta;
import br.com.desafiosebrae.dto.ContaDTO;

import br.com.desafiosebrae.repository.ContaRepository;

@Service
public class ContaService {
    
    @Autowired
    private ContaRepository contaRepository;

    public Conta converterEmEntidade(ContaDTO contaDto){

        if(contaDto == null){
            return null;
        }
        
        Conta conta = new Conta();

        conta.setDescricao(contaDto.getDescricao());
        conta.setNome(contaDto.getNome());

        return conta;
    }

    public ContaDTO converterEmDTO(Conta conta){

        if(conta == null){
            return null;
        }
        
        ContaDTO contaDto = new ContaDTO();

        contaDto.setDescricao(conta.getDescricao());
        contaDto.setNome(conta.getNome());

        return contaDto;
    }

    public Conta salvar(Conta conta){
        return contaRepository.save(conta);
    }
}
