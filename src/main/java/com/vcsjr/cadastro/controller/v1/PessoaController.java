package com.vcsjr.cadastro.controller.v1;

import com.vcsjr.cadastro.service.PessoaService;
import com.vcsjr.cadastro.domain.entity.Pessoa;
import com.vcsjr.cadastro.domain.request.PessoaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @Operation(summary = "/create", description = "Register a person on Database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> cadastrarPessoa(@Valid @RequestBody PessoaDTO pessoaDTO) {
        service.cadastrarPessoa(pessoaDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
