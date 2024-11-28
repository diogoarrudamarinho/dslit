package com.projeto.dslist.services;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
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

    public GameDTO create(Game newGame) {
        if (newGame.getId() != null && gameRepository.existsById(newGame.getId()))
            throw new IllegalArgumentException("User ID already exists");

        return new GameDTO(gameRepository.save(newGame));
    }

    public GameDTO findById(Long id) {
        return new GameDTO( gameRepository.findById(id)
                            .orElseThrow(() -> new ObjectNotFoundException(
                                                "Object not Found", id))); 
    }

    public GameDTO update(Long id, Game game) {
        Game newGame = gameRepository.findById(id).get();

        newGame.setTitle(game.getTitle());
        newGame.setYear(game.getYear());
        newGame.setGenre(game.getGenre());
        newGame.setPlatforms(game.getPlatforms());
        newGame.setScore(game.getScore());
        newGame.setImgUrl(game.getImgUrl());
        newGame.setShortDescription(game.getShortDescription());
        newGame.setLongDescription(game.getLongDescription());

        return new GameDTO(gameRepository.save(newGame)); 
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll()
                .stream().map(GameMinDTO::new)
                .toList();
    }
    
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        return gameRepository.searchByList(listId)
                .stream().map(GameMinDTO::new)
                .toList();
    }
}