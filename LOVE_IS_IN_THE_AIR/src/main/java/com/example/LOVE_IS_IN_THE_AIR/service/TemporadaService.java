package com.example.LOVE_IS_IN_THE_AIR.service;

import com.example.LOVE_IS_IN_THE_AIR.model.Temporada;
import com.example.LOVE_IS_IN_THE_AIR.repository.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemporadaService {
    @Autowired
    private TemporadaRepository temporadaRepository;

    public List<Temporada> obtenerTodasTemporadas() {
        return temporadaRepository.findAll();
    }

    public Temporada obtenerTemporadaPorId(Long id) {
        return temporadaRepository.findById(id).orElse(null);
    }

    public Temporada guardarTemporada(Temporada temporada) {
        return temporadaRepository.save(temporada);
    }
}