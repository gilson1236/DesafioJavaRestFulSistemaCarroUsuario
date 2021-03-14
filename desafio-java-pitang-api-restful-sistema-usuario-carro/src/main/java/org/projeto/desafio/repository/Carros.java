package org.projeto.desafio.repository;

import org.projeto.desafio.modelo.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Carros extends JpaRepository<Carro,Long>{

}
