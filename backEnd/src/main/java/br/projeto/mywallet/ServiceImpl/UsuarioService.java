package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.UsuarioDTO;
import br.projeto.mywallet.Mappers.UsuarioMapper;
import br.projeto.mywallet.Model.Usuario;
import br.projeto.mywallet.Service.IUsuarioService;
import br.projeto.mywallet.repository.IUsuarioRepository;
import java.util.HashSet;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        
        usuarioDTO.setCarteiras(new HashSet<>());
        
        Usuario usuario = UsuarioMapper.INSTANCE.toEntity(usuarioDTO);
        
        return UsuarioMapper.INSTANCE
                .toDTO(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioDTO atualizarUsuario(Long id, UsuarioDTO usuarioAtualizado) {
        
        UsuarioDTO usuarioDTO = buscarPorId(id);

        usuarioDTO.setNome(usuarioAtualizado.getNome());
        usuarioDTO.setDataNascimento(usuarioAtualizado.getDataNascimento());
        usuarioDTO.setEmail(usuarioAtualizado.getEmail());
        usuarioDTO.setSenha(usuarioAtualizado.getSenha());
        usuarioDTO.setCarteiras(usuarioAtualizado.getCarteiras());

        return UsuarioMapper.INSTANCE
                .toDTO(usuarioRepository.save(UsuarioMapper.INSTANCE.toEntity(usuarioDTO)));
    }

    @Override
    public void deletarUsuario(Long id) {
        
        UsuarioDTO usuarioDTO = buscarPorId(id);
        
        usuarioRepository.delete(UsuarioMapper.INSTANCE.toEntity(usuarioDTO));
    }

    @Override
    public UsuarioDTO buscarPorId(Long id) {
        
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        
        return usuario.map(UsuarioMapper.INSTANCE::toDTO)
                .orElseThrow(() -> new RuntimeException("Usuário com ID " + id + " não encontrado."));
    }

    @Override
    public List<UsuarioDTO> listarTodos() {
        
        return usuarioRepository.findAll().stream()
                .map(UsuarioMapper.INSTANCE::toDTO)
                .toList();
    }
}
