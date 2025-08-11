package com.hexaware.cms.restcontroller;

import com.hexaware.cms.dto.PlayerDto;
import com.hexaware.cms.entity.Player;
import com.hexaware.cms.service.IPlayerService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/players")
public class PlayerRestController {
	@Autowired 
	IPlayerService service;
	
	@PostMapping("/add")
	public Player createPlayer(@RequestBody PlayerDto dto) {
		return service.createPlayer(dto);
	}
	
	@GetMapping("/getall")
	public List<Player> getAllPlayers(){
		return service.getAllPlayers();
	}
	@GetMapping("/get/{playerId}")
	public Player getPlayerId(@PathVariable int playerId){
		return service.getPlayerById(playerId);
	}
	
	@PutMapping("/update/{playerId}")
	public Player updatePlayer(@PathVariable int playerId, @RequestBody PlayerDto dto){
		return service.updatePlayer(playerId, dto);
	}
	
	@DeleteMapping("/delete/{playerId}")
	public String deletePlayerById(@PathVariable int playerId) {
		return service.deletePlayerById(playerId);
	}
}
