package org.projeto.desafio.repository;

import org.projeto.desafio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User,Long>{

    Optional<User> findByEmail(String email);
    UserDetails findByLogin(String login);

}
