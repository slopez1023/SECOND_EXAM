package com.example.LOVE_IS_IN_THE_AIR.repository;

import com.example.LOVE_IS_IN_THE_AIR.model.Temporada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemporadaRepository extends JpaRepository<Temporada, Long> {}