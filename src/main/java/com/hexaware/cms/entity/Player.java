package com.hexaware.cms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

@Table(name="player")
public class Player {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int playerId;

    @Column(nullable = false)
    private String playerName;

    @Column(unique = true, nullable = false)
    private int jerseyNumber;

    @Column(nullable = false)
    private String role;

    private int totalMatches;
    private String teamName;
    private String country;
    private String description;

}
