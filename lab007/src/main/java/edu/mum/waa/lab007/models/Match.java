package edu.mum.waa.lab007.models;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Match {
	private Integer matchKey;
	
	@DateTimeFormat(iso = ISO.DATE)
	private Date date;

//	@DateTimeFormat(iso = ISO.TIME)
//	private LocalDateTime startTime;

	private int stadiumKey;
	private Stadium stadium;

	private int homeTeamKey;
	private Team homeTeam;
	private int homeScore;

	private int visitorTeamKey;
	private int visitorScore;
	private Team visitorTeam;
	
	public Integer getMatchKey() { return matchKey; }
	public void setMatchKey(Integer matchKey) { this.matchKey = matchKey; }
	
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }
	
//	public LocalDateTime getStartTime() { return startTime; }
//	public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
	
	public Stadium getStadium() { return stadium; }
	public void setStadium(Stadium stadium) { this.stadium = stadium; }
	
	public int getHomeScore() { return homeScore; }
	public void setHomeScore(int homeScore) { this.homeScore = homeScore; }
	
	public int getVisitorScore() { return visitorScore; }
	public void setVisitorScore(int visitorScore) { this.visitorScore = visitorScore; }
	
	public Team getVisitorTeam() { return visitorTeam; }
	public void setVisitorTeam(Team visitorTeam) { this.visitorTeam = visitorTeam; }
	
	public Team getHomeTeam() { return homeTeam; }
	public void setHomeTeam(Team homeTeam) { this.homeTeam = homeTeam; }
	
	public int getStadiumKey() { return this.stadiumKey; }
	public void setStadiumKey(int stadiumKey) { this.stadiumKey = stadiumKey; }
	
	public int getHomeTeamKey() { return this.homeTeamKey; }
	public void setHomeTeamKey(int homeTeamKey) { this.homeTeamKey = homeTeamKey; }
	
	public int getVisitorTeamKey() { return this.visitorTeamKey; }
	public void setVisitorTeamKey(int visitorTeamKey) { this.visitorTeamKey = visitorTeamKey; }
}
