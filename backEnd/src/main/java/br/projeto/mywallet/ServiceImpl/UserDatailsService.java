package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author wilsonramos
 */
@Service
public class UserDatailsService implements UserDetailsService{
    
    @Autowired
    private IUsuarioRepository usuarioRepository; 
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByNome(username)
                .orElseThrow(()-> new UsernameNotFoundException("Usuario não encontrado"));
                
                
    }
    
}
