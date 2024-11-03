package com.example.LOVE_IS_IN_THE_AIR.repository;

import com.example.LOVE_IS_IN_THE_AIR.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
}