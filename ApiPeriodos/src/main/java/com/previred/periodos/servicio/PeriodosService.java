package com.previred.periodos.servicio;

import com.previred.periodos.swagger.codegen.model.Periodo;
import com.previred.periodos.tools.RandomDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author mgonzalez@previred.com
 */
@Service
public class PeriodosService {
    private final static int MIN = 10;
    private final static int MAX = 30;
    
    /**
     * Genera una lista de Objetos periodos los rangos de fechas van de 1980 a 2019
     * el rango de lista de fechas en el periodo  va desde 10 a 30
     * @return 
     */
    public List<Periodo> getPeriodos(){
        RandomDate fechaInicial = new RandomDate(LocalDate.of(1980, 1, 1), LocalDate.of(2013, 1, 1));
        RandomDate fechaFin = new RandomDate(LocalDate.of(2013, 2, 1), LocalDate.of(2019, 1, 1));
        
        List<Periodo> periodos = new ArrayList();
        for (long id = 1l; id <= 100l; id++) {
            Periodo periodo = new Periodo();
            periodo.setId(id);
            periodo.setFechaCreacion(fechaInicial.nextDate());
            periodo.setFechaFin(fechaFin.nextDate());
            RandomDate fechaPeriodos = new RandomDate(periodo.getFechaCreacion(), periodo.getFechaFin());
            
            Random aleatorio = new Random();
            int cantidadPeriodos = aleatorio.nextInt((MAX - MIN) + 1) + MIN;
            List<LocalDate> fechas = new ArrayList();
            for (int e = 1; e <  cantidadPeriodos; e++) {
                fechas.add(fechaPeriodos.nextDate());
            }
            periodo.setFechas(fechas.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList()));
            periodos.add(periodo);
        }
        
        return periodos;
    }
}
