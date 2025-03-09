package br.projeto.mywallet.Service;

import br.projeto.mywallet.DTO.UsuarioDTO;
import br.projeto.mywallet.Model.Usuario;

import java.util.List;

public interface IUsuarioService {
    UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO);

    void deletarUsuario(Long id);

    UsuarioDTO buscarPorId(Long id);

    UsuarioDTO login(UsuarioDTO usuarioDTO) throws Exception;

    List<UsuarioDTO> listarTodos();
}
