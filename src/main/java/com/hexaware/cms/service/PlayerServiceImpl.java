package com.hexaware.cms.service;

import com.hexaware.cms.dto.PlayerDto;
import com.hexaware.cms.entity.Player;
import com.hexaware.cms.repository.PlayerRepository;
import com.hexaware.cms.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for Player-related operations.
 * This class handles the business logic for managing players
 * and interacts with the repository layer to perform CRUD operations.
 */

@Service
public class PlayerServiceImpl implements IPlayerService {

	@Autowired
	PlayerRepository repo;//Repository for database operations 
	
	private Player mapDTOToEntity(PlayerDto dto, Player player) { //Mapping entity to dto and saving in database
		if(player== null) {player=new Player();}
		player.setPlayerId(dto.getPlayerId());
		player.setPlayerName(dto.getPlayerName());
		player.setJerseyNumber(dto.getJerseyNumber());
		player.setRole(dto.getRole());
		player.setTeamName(dto.getTeamName());
		player.setTotalMatches(dto.getTotalMatches());
		player.setCountry(dto.getCountry());
		player.setDescription(dto.getDescription());
		return player;
	}
	@Override
	public List<Player> getAllPlayers() {
		
		return repo.findAll();
	}
	
	@Override
	public Player createPlayer(PlayerDto dto) {
		
		return repo.save(mapDTOToEntity(dto, null));
	}

	@Override
	public Player getPlayerById(int playerId) {
		
		return repo.findById((int) playerId).orElse(null);
	}

	
	@Override
	public Player updatePlayer(int playerId, PlayerDto dto) {
	    Player existing = repo.findById(playerId)
	            .orElseThrow(() -> new RuntimeException("Player with ID " + playerId + " not found"));

	    existing.setPlayerName(dto.getPlayerName());
	    existing.setJerseyNumber(dto.getJerseyNumber());
	    existing.setRole(dto.getRole());
	    existing.setTotalMatches(dto.getTotalMatches());
	    existing.setTeamName(dto.getTeamName());
	    existing.setCountry(dto.getCountry());
	    existing.setDescription(dto.getDescription());

	    return repo.save(existing);
	}

	@Override
	public String deletePlayerById(int playerId) {
		
		repo.deleteById((int) playerId);
		return "Deleted Successfully";
	}
	
	 @Override
	    public List<Player> getPlayersByName(String playerName) {
	        return repo.findByPlayerName(playerName);
	    }
	 
	 @Override
	    public List<Player> getPlayersByRole(String role) {
	        return repo.findByRole(role);
	    }
	 
	 @Override
	    public List<Player> getPlayersStartingWith(String prefix) {
		 return repo.findPlayersByNameStartingWith(prefix);
		 
	       // return repo.findByPlayerNameStartingWithIgnoreCase(prefix);
	    }

}
