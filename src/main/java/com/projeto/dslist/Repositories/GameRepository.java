package com.projeto.dslist.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    
}
