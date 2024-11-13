package com.projeto.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.dslist.Repositories.GameRepository;
import com.projeto.dslist.dto.GameMinDTO;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        return gameRepository.findAll()
                .stream().map(game -> new GameMinDTO(game))
                .toList();
    }

    
}