package com.projeto.dslist.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
    
}
