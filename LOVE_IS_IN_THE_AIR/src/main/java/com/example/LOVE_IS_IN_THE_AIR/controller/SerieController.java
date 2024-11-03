package com.example.LOVE_IS_IN_THE_AIR.controller;


import com.example.LOVE_IS_IN_THE_AIR.model.Serie;
import com.example.LOVE_IS_IN_THE_AIR.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series")
@Controller
public class SerieController {
    @Autowired
    private SerieService serieService;

    @GetMapping
    public List<Serie> obtenerSeries() {
        return serieService.obtenerTodasSeries();
    }

    @GetMapping("/{id}")
    public Serie obtenerSeriePorId(@PathVariable Long id) {
        return serieService.obtenerSeriePorId(id);
    }

    @PostMapping
    public Serie crearSerie(@RequestBody Serie serie) {
        return serieService.guardarSerie(serie);
    }
}
