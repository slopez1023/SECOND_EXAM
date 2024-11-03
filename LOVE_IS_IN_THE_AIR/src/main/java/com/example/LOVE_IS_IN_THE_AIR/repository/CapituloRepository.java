package com.example.LOVE_IS_IN_THE_AIR.repository;

import com.example.LOVE_IS_IN_THE_AIR.model.Capitulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CapituloRepository extends JpaRepository<Capitulo, Long> {
    List<Capitulo> findByTemporada_Serie_Id(Long serieId);
}
