package com.example.LOVE_IS_IN_THE_AIR.controller;


import com.example.LOVE_IS_IN_THE_AIR.model.Personaje;
import com.example.LOVE_IS_IN_THE_AIR.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personajes")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;

    @GetMapping
    public List<Personaje> obtenerPersonajes() {
        return personajeService.obtenerTodosPersonajes();
    }

    @GetMapping("/{id}")
    public Personaje obtenerPersonajePorId(@PathVariable Long id) {
        return personajeService.obtenerPersonajePorId(id);
    }

    @PostMapping
    public Personaje crearPersonaje(@RequestBody Personaje personaje) {
        return personajeService.guardarPersonaje(personaje);
    }
}