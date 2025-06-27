package com.api.apijwt.repository;

import com.api.apijwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Encontra um usuário pelo seu nome de usuário.
     * Como os nomes de usuário são únicos, isso deve retornar no máximo um usuário.
     *
     * @param username 
     * @return 
     */
    Optional<User> findByUsername(String username);
}
