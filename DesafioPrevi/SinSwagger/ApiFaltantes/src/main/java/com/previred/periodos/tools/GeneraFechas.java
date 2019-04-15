package com.previred.periodos.tools;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GeneraFechas {
	
	public static List<LocalDate> rellena (LocalDate inicio, LocalDate fin, List<LocalDate> fechas){
		
		Set<LocalDate> fechasAux = new HashSet<LocalDate>();
		while(inicio.isBefore(fin)) {
			inicio = inicio.plusMonths(1);
			Boolean flag = false;
			for(LocalDate auxFechas : fechas) {
			 if(auxFechas.equals(inicio))
				 flag = true;
		    }
			if(!flag)
			fechasAux.add(inicio);			
		}
		
		return fechasAux.stream()
				.sorted()
				.collect(Collectors.toList());
	}

}
