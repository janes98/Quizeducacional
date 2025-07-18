package com.janequiz.quizeducacional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.janequiz.quizeducacional.entities.Ranking;

public interface RankingRepository extends JpaRepository<Ranking, Long>{
	

}
