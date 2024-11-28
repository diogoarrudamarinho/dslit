package com.projeto.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.dslist.dto.GameDTO;
import com.projeto.dslist.dto.GameMinDTO;
import com.projeto.dslist.entities.Game;
import com.projeto.dslist.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    public Game create(Game newGame){
        if (newGame.getId() != null && gameRepository.existsById(newGame.getId()))
            throw new IllegalArgumentException("User ID already exists");
        
        return gameRepository.save(newGame);
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        return new GameDTO(gameRepository.findById(id).get());
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        return gameRepository.findAll()
                .stream().map(game -> new GameMinDTO(game))
                .toList();
    }
    
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        return gameRepository.searchByList(listId)
                .stream().map(game -> new GameMinDTO(game))
                .toList();
    }
}