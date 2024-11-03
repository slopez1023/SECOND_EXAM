package com.example.LOVE_IS_IN_THE_AIR.service;


import com.example.LOVE_IS_IN_THE_AIR.model.Capitulo;
import com.example.LOVE_IS_IN_THE_AIR.repository.CapituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapituloService {
    @Autowired
    private CapituloRepository capituloRepository;

    public List<Capitulo> obtenerTodosCapitulos() {
        return capituloRepository.findAll();
    }

    public Capitulo obtenerCapituloPorId(Long id) {
        return capituloRepository.findById(id).orElse(null);
    }

    public Capitulo guardarCapitulo(Capitulo capitulo) {
        return capituloRepository.save(capitulo);
    }

}
