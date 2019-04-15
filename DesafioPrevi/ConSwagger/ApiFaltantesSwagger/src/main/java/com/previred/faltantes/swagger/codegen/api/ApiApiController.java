package com.previred.faltantes.swagger.codegen.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.previred.faltantes.servicio.PeriodosService;
import com.previred.faltantes.swagger.codegen.model.Periodo;
import com.previred.faltantes.swagger.codegen.model.PeriodosFaltantes;
import com.previred.faltantes.tools.RellenaFechasFaltantes;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
public class ApiApiController implements ApiApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private PeriodosService periodosService;

    @org.springframework.beans.factory.annotation.Autowired
    public ApiApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

    @Override
    public ResponseEntity<PeriodosFaltantes> periodos(RestTemplate restTemplate) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                	
                	Periodo periodo = restTemplate.getForObject(
            				"http://127.0.0.1:8080/periodos/api", Periodo.class);
            		PeriodosFaltantes periodoFaltante = new PeriodosFaltantes();
            		periodoFaltante.setId(periodo.getId());
            		periodoFaltante.setFechaCreacion(periodo.getFechaCreacion());
            		periodoFaltante.setFechaFin(periodo.getFechaFin());
            		periodoFaltante.setFechas(periodo.getFechas());
            		periodoFaltante.setFechasFaltantes(RellenaFechasFaltantes.rellena(periodo.getFechaCreacion(),periodo.getFechaFin(),periodo.getFechas()));
                	ResponseEntity<PeriodosFaltantes> respuesta = new ResponseEntity<>(periodoFaltante, HttpStatus.OK);
                    return respuesta;
                } catch (Exception e) {
                    log.error("Couldn't serialize response for content type application/xml", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default DefaultApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
