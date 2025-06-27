package com.api.apijwt.service;

import com.api.apijwt.model.User;
import com.api.apijwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Autentica um usuário e gera um JWT.
     *
     * @param username O nome de usuário do usuário.
     * @param password A senha do usuário.
     * @return Uma string JWT se a autenticação for bem-sucedida.
     */
    public String login(String username, String password) {
        // O AuthenticationManager do Spring Security cuidará da verificação de usuário/senha.
        // Ele usa o UserDetailsService e o PasswordEncoder configurados.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        // Se a autenticação for bem-sucedida, gere um token.
        // O "principal" é o objeto UserDetails.
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtService.generateToken(userDetails);
    }
}
