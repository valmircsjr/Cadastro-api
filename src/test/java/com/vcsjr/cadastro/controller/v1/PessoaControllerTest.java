package com.vcsjr.cadastro.controller.v1;

import com.vcsjr.cadastro.service.PessoaService;
import com.vcsjr.cadastro.domain.entity.Pessoa;
import com.vcsjr.cadastro.domain.request.PessoaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PessoaControllerTest {

    @Mock
    private PessoaService service;

    @InjectMocks
    private PessoaController controller;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    void testCadastrarPessoa() {
        PessoaDTO pessoaDTO = new PessoaDTO();
        ResponseEntity<Pessoa> expectedResponse = ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        ResponseEntity<Pessoa> response = controller.cadastrarPessoa(pessoaDTO);

        assertEquals(expectedResponse.getStatusCode(), response.getStatusCode());
        verify(service).cadastrarPessoa(any(PessoaDTO.class));
    }
}