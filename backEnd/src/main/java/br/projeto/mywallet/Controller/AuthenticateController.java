package br.projeto.mywallet.Controller;

import br.projeto.mywallet.ServiceImpl.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wilsonramos
 */
@RestController
@RequestMapping("/authenticate")
public class AuthenticateController {
    
    @Autowired
    private AuthenticationService authenticationService;
    
    @PostMapping
    public ResponseEntity geraToken(Authentication authentication){
        return ResponseEntity.ok(authenticationService.authenticate(authentication));
    }
}
