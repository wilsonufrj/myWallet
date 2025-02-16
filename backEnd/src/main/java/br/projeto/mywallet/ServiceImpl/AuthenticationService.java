package br.projeto.mywallet.ServiceImpl;

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
    
    public String authenticate(Authentication authentication){
        return jwtService.gerarToken(authentication);
    }
}
