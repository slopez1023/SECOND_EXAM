package com.example.LOVE_IS_IN_THE_AIR.service;

import com.example.LOVE_IS_IN_THE_AIR.model.Personaje;
import com.example.LOVE_IS_IN_THE_AIR.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {
    @Autowired
    private PersonajeRepository personajeRepository;

    public List<Personaje> obtenerTodosPersonajes() {
        return personajeRepository.findAll();
    }

    public Personaje obtenerPersonajePorId(Long id) {
        return personajeRepository.findById(id).orElse(null);
    }

    public Personaje guardarPersonaje(Personaje personaje) {
        return personajeRepository.save(personaje);
    }
}