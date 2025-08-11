package com.hexaware.cms.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayerDto {
	
	 private int playerId;

	    @NotBlank(message = "Player name is required")
	    @Pattern(regexp = "^[A-Za-z ]{3,50}$", message = "Name must be 3-50 letters only")
	    private String playerName;

	    @NotNull(message = "Jersey number is required")
	    @Min(value = 1, message = "Jersey number must be positive")
	    @Max(value = 999, message = "Jersey number cannot exceed 3 digits")
	    private int jerseyNumber;

	    @NotBlank(message = "Role is required")
	    @Pattern(regexp = "Batsman|Bowler|Keeper|All Rounder", 
	             message = "Role must be Batsman, Bowler, Keeper, or All Rounder")
	    private String role;

	    @Min(value = 0, message = "Matches cannot be negative")
	    private int totalMatches;

	    @NotBlank(message = "Team name is required")
	    private String teamName;

	    @NotBlank(message = "Country is required")
	    private String country;

	    @Size(max = 200, message = "Description cannot exceed 200 characters")
	    private String description;

}
