package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.model.Telefone;

//DTO request
public record UsuarioDTO(
    String nome,
    String login,
    String senha,
    List<TelefoneDTO> listaTelefone
) {
 
}
