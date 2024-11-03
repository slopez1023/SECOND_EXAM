package com.example.LOVE_IS_IN_THE_AIR.controller;

import com.example.LOVE_IS_IN_THE_AIR.model.Temporada;
import com.example.LOVE_IS_IN_THE_AIR.service.TemporadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temporadas")
public class TemporadaController {
    @Autowired
    private TemporadaService temporadaService;

    @GetMapping
    public List<Temporada> obtenerTemporadas() {
        return temporadaService.obtenerTodasTemporadas();
    }

    @GetMapping("/{id}")
    public Temporada obtenerTemporadaPorId(@PathVariable Long id) {
        return temporadaService.obtenerTemporadaPorId(id);
    }

    @PostMapping
    public Temporada crearTemporada(@RequestBody Temporada temporada) {
        return temporadaService.guardarTemporada(temporada);
    }
}