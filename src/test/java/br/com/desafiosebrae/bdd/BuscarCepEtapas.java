package br.com.desafiosebrae.bdd;

import static org.mockito.Mockito.when;

import org.mockito.Mockito;

import br.com.desafiosebrae.dto.CepDTO;
import br.com.desafiosebrae.service.CepService;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static org.junit.Assert.assertEquals;

public class BuscarCepEtapas {
    
    private CepDTO cepDTO;

    private CepService cepService;

    @Dado("que informei o cep 64053070")
    public void que_hoje_e_domingo() {
       this.cepService = Mockito.mock(CepService.class);
    }

    @Quando("eu solicito a api as informacoes do cep")
    public void quando_eu_pergunto_se_ainda_e_sexta_feira() {
        CepDTO cepDTO = new CepDTO();
        cepDTO.setLogradouro("Rua Antilhon Ribeiro Soares");
        cepDTO.setBairro("Santa Isabel");
        cepDTO.setLocalidade("Teresina");
        cepDTO.setUf("PI");
        cepDTO.setIbge("2211001");
        cepDTO.setDdd("86");
        cepDTO.setSiafi("1219");

        when(cepService.buscarCep(Mockito.anyString())).thenReturn(cepDTO);

        this.cepDTO = cepService.buscarCep("64053070");
    }


    @Entao("eu deveria ser informado que o logradouro é {string}")
    public void entao_eu_deveria_ser_informado_que_o_logradouro(String logradouro) {
        assertEquals(logradouro, cepDTO.getLogradouro());
    }

    @E("o bairro é {string}")
    public void e_o_bairro_e(String bairro) {
        assertEquals(bairro, cepDTO.getBairro());
    }

    @E("a localidade é {string}")
    public void e_a_localidade_e(String localidade) {
        assertEquals(localidade, cepDTO.getLocalidade());
    }

    @E("a uf é {string}")
    public void e_uf_e(String uf) {
        assertEquals(uf, cepDTO.getUf());
    }

    @E("o ibge é {string}")
    public void e_ibge_e(String ibge) {
        assertEquals(ibge, cepDTO.getIbge());
    }

    @E("o ddd é {string}")
    public void e_ddd_e(String ddd) {
        assertEquals(ddd, cepDTO.getDdd());
    }

    @E("o siafi é {string}")
    public void e_siafi_e(String siafi) {
        assertEquals(siafi, cepDTO.getSiafi());
    }
}
