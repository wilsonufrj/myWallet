package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.AuthenticateDTO;
import br.projeto.mywallet.Model.Usuario;
import br.projeto.mywallet.Service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 *
 * @author wilsonramos
 */
@Service
public class AuthenticationService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUsuarioService usuarioService;

    public AuthenticateDTO authenticate(Authentication authentication) {
        String token = jwtService.gerarToken(authentication);
        Usuario usuario = usuarioService.buscaUsuarioPorNome(authentication.getName());

        return (new AuthenticateDTO(token, usuario.getUsername(), usuario.getId()));

    }
}
