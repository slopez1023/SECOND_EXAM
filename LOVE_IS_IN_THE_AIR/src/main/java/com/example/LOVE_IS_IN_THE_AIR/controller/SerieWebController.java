package com.example.LOVE_IS_IN_THE_AIR.controller;

import com.example.LOVE_IS_IN_THE_AIR.model.Capitulo;
import com.example.LOVE_IS_IN_THE_AIR.model.Personaje;
import com.example.LOVE_IS_IN_THE_AIR.model.Serie;
import com.example.LOVE_IS_IN_THE_AIR.model.Temporada;
import com.example.LOVE_IS_IN_THE_AIR.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SerieWebController {

    @Autowired
    private SerieService serieService;

    @GetMapping("/")
    public String mostrarPaginaPrincipal(Model model) {
        Serie serie = serieService.obtenerSeriePorId(1L); // ID=1 como ejemplo
        double promedioCalificacion = serieService.obtenerPromedioCalificacion(1L);
        Capitulo mejorCapitulo = serieService.obtenerCapituloMejorCalificado(1L);

        model.addAttribute("serie", serie);
        model.addAttribute("promedioCalificacion", promedioCalificacion);
        model.addAttribute("mejorCapitulo", mejorCapitulo);

        return "index";
    }

    @GetMapping("/series/{id}")
    public String mostrarSerie(@PathVariable Long id, Model model) {
        model.addAttribute("serie", serieService.obtenerSeriePorId(id));
        return "serie";
    }

    @GetMapping("/series/{serieId}/temporada/{temporadaNumero}")
    public String verTemporada(@PathVariable Long serieId, @PathVariable int temporadaNumero, Model model) {
        Temporada temporada = serieService.obtenerTemporadaPorSerieYNumero(serieId, temporadaNumero);
        if (temporada == null) {
            return "error/404";
        }
        model.addAttribute("temporada", temporada);
        return "temporada";
    }

    @GetMapping("/series/{serieId}/personajes")
    public String verPersonajes(@PathVariable Long serieId, Model model) {
        Serie serie = serieService.obtenerSeriePorId(serieId);
        if (serie == null) {
            return "error/404";
        }
        model.addAttribute("serie", serie);
        return "personaje";
    }

    @GetMapping("/{id}/info")
    @ResponseBody
    public ResponseEntity<Serie> obtenerInformacionSerie(@PathVariable Long id) {
        Serie serie = serieService.obtenerSeriePorId(id);
        return serie != null ? ResponseEntity.ok(serie) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/temporadas")
    @ResponseBody
    public ResponseEntity<List<Temporada>> obtenerTemporadasSerie(@PathVariable Long id) {
        Serie serie = serieService.obtenerSeriePorId(id);
        return serie != null ? ResponseEntity.ok(serie.getTemporadas()) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/personajes-json")
    @ResponseBody
    public ResponseEntity<List<Personaje>> obtenerPersonajesSerie(@PathVariable Long id) {
        Serie serie = serieService.obtenerSeriePorId(id);
        return serie != null ? ResponseEntity.ok(serie.getPersonajes()) : ResponseEntity.notFound().build();
    }

    // Método para ver los detalles de un capítulo específico
    @GetMapping("/series/{serieId}/temporada/{temporadaNumero}/capitulo/{capituloId}")
    public String verCapitulo(@PathVariable Long serieId, @PathVariable int temporadaNumero,
                              @PathVariable Long capituloId, Model model) {
        Capitulo capitulo = serieService.obtenerCapituloPorId(capituloId);
        if (capitulo == null) {
            return "error/404";
        }
        model.addAttribute("capitulo", capitulo);
        return "capitulo"; // Nombre de la plantilla HTML para los detalles del capítulo
    }

}
