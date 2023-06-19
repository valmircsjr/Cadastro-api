package com.vcsjr.cadastro.service;

import com.vcsjr.cadastro.domain.entity.Pessoa;
import com.vcsjr.cadastro.repository.PessoaRepository;
import com.vcsjr.cadastro.domain.request.PessoaDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public void cadastrarPessoa(PessoaDTO pessoaDTO) {

        Pessoa pessoa = Pessoa.builder()
                .nome(pessoaDTO.getNome())
                .identificador(pessoaDTO.getIdentificador())
                .tipoIdentificador(getTipoIdentificador(pessoaDTO.getIdentificador()))
                .build();

        pessoaRepository.save(pessoa);
    }

    public String getTipoIdentificador(String identificador) {

        if (identificador.length() == 11) {
            return "CPF";
        } else if (identificador.length() == 14) {
            return "CNPJ";
        } else {
            throw new IllegalArgumentException("Identificador inválido");
        }

    }
}

