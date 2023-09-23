package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Estado;

public record EstadoResponseDTO(
        Long id,
        String nome,
        String sigla) {
            public static EstadoResponseDTO valueof(Estado estado){
                return new EstadoResponseDTO(estado.getId(), estado.getNome(), estado.getSigla());
            }
        }
