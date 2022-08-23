package com.mlb.mlb_api.controllers;


import com.mlb.mlb_api.repositories.entities.Player;
import com.mlb.mlb_api.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @PostMapping("/addPlayer")
    public Player addPlayer(@RequestBody Player player){
        return this.playerRepository.save(player);

    }

    @GetMapping("/all")
    public Iterable<Player> getAllPlayers(){
        return this.playerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Player> getPlayerById (@PathVariable("id") Integer playerId){
        return this.playerRepository.findById(playerId);
    }

    @PutMapping("/update/{id}")
    public Player updatePlayer (@PathVariable("id") Integer playerId, @RequestBody Player player){
        //find original player from database
        Optional<Player> playerFromDB = this.playerRepository.findById(playerId);
        if(!playerFromDB.isPresent()){
            return null;
        }
        Player playerNeedUpdate = playerFromDB.get();

        playerNeedUpdate.setName(player.getName());
        playerNeedUpdate.setAge(player.getAge());
        playerNeedUpdate.setRating(player.getRating());
        playerNeedUpdate.setYearsOfExperience(player.getYearsOfExperience());

        return this.playerRepository.save(playerNeedUpdate);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable("id") Integer playerId){
        Optional<Player> playerDB = this.playerRepository.findById(playerId);
        if(playerDB.isPresent()){
            this.playerRepository.deleteById(playerId);
            throw new ResponseStatusException(HttpStatus.OK, "The player has been successfully deleted");
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The player was not found.");

        }
    }




}
