package com.example.LOVE_IS_IN_THE_AIR.service;

import com.example.LOVE_IS_IN_THE_AIR.model.Capitulo;
import com.example.LOVE_IS_IN_THE_AIR.model.Serie;
import com.example.LOVE_IS_IN_THE_AIR.model.Temporada;
import com.example.LOVE_IS_IN_THE_AIR.repository.CapituloRepository;
import com.example.LOVE_IS_IN_THE_AIR.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
public class SerieService {
    @Autowired
    private SerieRepository serieRepository;
    @Autowired
    private CapituloRepository capituloRepository;

    public List<Serie> obtenerTodasSeries() {
        return serieRepository.findAll();
    }

    public Serie obtenerSeriePorId(Long id) {
        return serieRepository.findById(id).orElse(null);
    }

    public Serie guardarSerie(Serie serie) {
        return serieRepository.save(serie);
    }
    // Obtener el promedio de calificación de los capítulos de una serie
    // Obtener el promedio de calificaciones de los capítulos de una serie
    public double obtenerPromedioCalificacion(Long serieId) {
        List<Capitulo> capitulos = capituloRepository.findByTemporada_Serie_Id(serieId);

        // Convertir BigDecimal a double usando mapToDouble con .doubleValue()
        OptionalDouble promedio = capitulos.stream()
                .mapToDouble(capitulo -> capitulo.getCalificacion().doubleValue())
                .average();

        return promedio.orElse(0.0); // Retorna 0.0 si no hay capítulos
    }

    // Obtener el capítulo mejor calificado de la serie
    public Capitulo obtenerCapituloMejorCalificado(Long serieId) {
        // Usar .doubleValue() en el comparador para BigDecimal
        return capituloRepository.findByTemporada_Serie_Id(serieId).stream()
                .max((c1, c2) -> Double.compare(c1.getCalificacion().doubleValue(), c2.getCalificacion().doubleValue()))
                .orElse(null); // Retorna null si no hay capítulos
    }

    public Temporada obtenerTemporadaPorSerieYNumero(Long serieId, int numero) {
        Serie serie = obtenerSeriePorId(serieId);
        if (serie != null) {
            return serie.getTemporadas().stream()
                    .filter(temp -> temp.getNumero() == numero)
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }
    public Capitulo obtenerCapituloPorId(Long capituloId) {
        return capituloRepository.findById(capituloId).orElse(null);
    }


}