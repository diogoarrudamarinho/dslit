package com.projeto.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.dslist.Repositories.GameListRepository;
import com.projeto.dslist.dto.GameListDTO;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        return gameListRepository.findAll()
                .stream().map(gameList -> new GameListDTO(gameList))
                .toList();
    }
    
}
