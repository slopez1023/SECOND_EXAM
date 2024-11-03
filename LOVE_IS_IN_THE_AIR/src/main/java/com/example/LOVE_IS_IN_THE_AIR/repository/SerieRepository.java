package com.example.LOVE_IS_IN_THE_AIR.repository;

import com.example.LOVE_IS_IN_THE_AIR.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {}