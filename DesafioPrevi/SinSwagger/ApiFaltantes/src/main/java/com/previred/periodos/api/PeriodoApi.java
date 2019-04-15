package com.previred.periodos.api;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.previred.periodos.model.Periodo;
import com.previred.periodos.model.PeriodoFaltantes;
import com.previred.periodos.tools.GeneraFechas;

@RestController
public class PeriodoApi {
	

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@RequestMapping(value="/periodo", method=RequestMethod.GET)
    public String obtener(RestTemplate restTemplate){
		Periodo periodo = restTemplate.getForObject(
				"http://127.0.0.1:8080/periodos/api", Periodo.class);
		return periodo.toString();
    }
	
	@RequestMapping(value="/periodosFaltantes", method=RequestMethod.GET)
    public PeriodoFaltantes obtenerFaltantes(RestTemplate restTemplate){
		Periodo periodo = restTemplate.getForObject(
				"http://127.0.0.1:8080/periodos/api", Periodo.class);
		PeriodoFaltantes periodoFaltante = new PeriodoFaltantes();
		periodoFaltante.setId(periodo.getId());
		periodoFaltante.setFechaCreacion(periodo.getFechaCreacion());
		periodoFaltante.setFechaFin(periodo.getFechaFin());
		periodoFaltante.setFechas(periodo.getFechas());
		periodoFaltante.setFechasFaltantes(GeneraFechas.rellena(periodo.getFechaCreacion(),periodo.getFechaFin(),periodo.getFechas()));
		return periodoFaltante;
    }
	

}
