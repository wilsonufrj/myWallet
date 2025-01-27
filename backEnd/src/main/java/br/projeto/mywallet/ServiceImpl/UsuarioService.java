package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.Model.Usuario;
import br.projeto.mywallet.Service.IUsuarioService;
import br.projeto.mywallet.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setDataNascimento(usuarioAtualizado.getDataNascimento());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setSenha(usuarioAtualizado.getSenha());
            usuario.setCateiras(usuarioAtualizado.getCateiras());
            return usuarioRepository.save(usuario);
        }
        throw new RuntimeException("Usuário com o ID " + id + " não encontrado.");
    }

    @Override
    public void deletarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário com o ID " + id + " não encontrado.");
        }
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Usuário com o ID " + id + " não encontrado."));
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
}
