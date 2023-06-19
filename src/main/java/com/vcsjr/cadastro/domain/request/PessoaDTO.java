package com.vcsjr.cadastro.domain.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PessoaDTO {

    @NotNull(message = "O campo nome é obrigatorio")
    @Valid
    private String nome;

    @NotNull(message = "O campo identificador é obrigatorio")
    @Valid
    private String identificador;

}
