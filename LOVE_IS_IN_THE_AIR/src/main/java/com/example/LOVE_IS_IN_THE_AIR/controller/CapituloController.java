package com.example.LOVE_IS_IN_THE_AIR.controller;

import com.example.LOVE_IS_IN_THE_AIR.model.Capitulo;
import com.example.LOVE_IS_IN_THE_AIR.service.CapituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/capitulos")
public class CapituloController {
    @Autowired
    private CapituloService capituloService;

    @GetMapping
    public List<Capitulo> obtenerCapitulos() {
        return capituloService.obtenerTodosCapitulos();
    }

    @GetMapping("/{id}")
    public Capitulo obtenerCapituloPorId(@PathVariable Long id) {
        return capituloService.obtenerCapituloPorId(id);
    }

    @PostMapping
    public Capitulo crearCapitulo(@RequestBody Capitulo capitulo) {
        return capituloService.guardarCapitulo(capitulo);
    }
}