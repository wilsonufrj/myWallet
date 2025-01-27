package br.projeto.mywallet.Service;

import br.projeto.mywallet.Model.Usuario;
import java.util.List;

public interface IUsuarioService {
    Usuario criarUsuario(Usuario usuario);
    Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado);
    void deletarUsuario(Long id);
    Usuario buscarPorId(Long id);
    List<Usuario> listarTodos();
}
