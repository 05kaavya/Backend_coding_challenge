package com.hexaware.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.cms.entity.Player;

/**
 * PlayerRepository interacts with the database for Player entities.
 * Best Practices:
 * - Keep repository interfaces clean; avoid business logic here.
 * - Name methods clearly to indicate their purpose.
 */


public interface  PlayerRepository extends JpaRepository<Player,Integer>{

	 List<Player> findByPlayerName(String playerName);
	 
	 List<Player> findByRole(String role);
	 
	 @Query("SELECT p FROM Player p WHERE LOWER(p.playerName) LIKE LOWER(CONCAT(:prefix, '%'))")
	 List<Player> findPlayersByNameStartingWith(@Param("prefix") String prefix);
	 
	// List<Player> findByPlayerNameStartingWithIgnoreCase(String prefix);
}
