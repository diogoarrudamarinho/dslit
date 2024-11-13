package com.projeto.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
    
}
