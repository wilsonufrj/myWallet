package br.projeto.mywallet.Service;

import br.projeto.mywallet.DTO.UsuarioDTO;
import br.projeto.mywallet.Model.Usuario;
import java.util.List;

public interface IUsuarioService {
    UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO atualizarUsuario(Long id, UsuarioDTO usuarioAtualizadoDTO);
    void deletarUsuario(Long id);
    UsuarioDTO buscarPorId(Long id);
    List<UsuarioDTO> listarTodos();
}
