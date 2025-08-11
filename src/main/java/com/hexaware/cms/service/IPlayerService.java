package com.hexaware.cms.service;

import com.hexaware.cms.dto.PlayerDto;
import com.hexaware.cms.entity.Player;

import java.util.List;

public interface IPlayerService {
	public List<Player> getAllPlayers();
	public Player createPlayer(PlayerDto dto);
	public Player getPlayerById(int playerId);
	public Player updatePlayer(int playerId, PlayerDto dto);
	public String deletePlayerById(int playerId);
	public List<Player> getPlayersByName(String playerName);
	public List<Player> getPlayersByRole(String role);
	public List<Player> getPlayersStartingWith(String prefix);
}

	



