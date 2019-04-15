package com.previred.periodos.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonDeserialize(as = Periodo.class)
public class Periodo {
	
	  @JsonProperty("id")
	  private Long id;

	  @JsonProperty("fechaCreacion")
	  private LocalDate fechaCreacion;

	  @JsonProperty("fechaFin")
	  private LocalDate fechaFin;

	  @JsonProperty("fechas")
	  @Valid
	  private List<LocalDate> fechas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<LocalDate> getFechas() {
		return fechas;
	}

	public void setFechas(List<LocalDate> fechas) {
		this.fechas = fechas;
	}

	@Override
	public String toString() {
		return "Periodo [id=" + id + ", fechaCreacion=" + fechaCreacion + ", fechaFin=" + fechaFin + ", fechas="
				+ fechas + "]";
	}



	  
	  
}
