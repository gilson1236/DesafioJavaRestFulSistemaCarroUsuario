package org.projeto.desafio.repository;

import org.projeto.desafio.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usuarios extends JpaRepository <Usuario,Long>{

}
