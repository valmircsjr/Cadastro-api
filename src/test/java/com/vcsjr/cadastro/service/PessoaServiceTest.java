package com.vcsjr.cadastro.service;

import com.vcsjr.cadastro.domain.entity.Pessoa;
import com.vcsjr.cadastro.repository.PessoaRepository;
import com.vcsjr.cadastro.domain.request.PessoaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    private PessoaService pessoaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        pessoaService = new PessoaService(pessoaRepository);
    }

    @Test
    void testCadastrarPessoa() {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("John Doe");
        pessoaDTO.setIdentificador("00000000000");

        pessoaService.cadastrarPessoa(pessoaDTO);

        verify(pessoaRepository).save(
                Pessoa.builder()
                        .nome("John Doe")
                        .identificador("00000000000")
                        .tipoIdentificador("CPF")
                        .build()
        );
    }

    @Test
    void testGetTipoIdentificadorWithCPF() {
        String identificador = "12345678901";
        String tipoIdentificador = pessoaService.getTipoIdentificador(identificador);
        assertEquals("CPF", tipoIdentificador);
    }

    @Test
    void testGetTipoIdentificadorWithCNPJ() {
        String identificador = "12345678901234";
        String tipoIdentificador = pessoaService.getTipoIdentificador(identificador);
        assertEquals("CNPJ", tipoIdentificador);
    }

    @Test
    void testGetTipoIdentificadorWithInvalidIdentificador() {
        String identificador = "123";
        assertThrows(IllegalArgumentException.class, () -> pessoaService.getTipoIdentificador(identificador));
    }
}
