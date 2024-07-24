package py.edu.ucsa.jweb.rest.api.web.validators.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import py.edu.ucsa.jweb.rest.api.core.entities.Socio;
import py.edu.ucsa.jweb.rest.api.web.dto.ErrorDTO;
import py.edu.ucsa.jweb.rest.api.web.validators.Validador;

public class SocioValidadorFechas implements Validador<Socio> {

	@Override
	public List<ErrorDTO> validar(Socio obj) {
		List<ErrorDTO> errores = new ArrayList<>();
		
		//VALIDACIONES A VERIFICAR
		if(isFechaFutura(obj.getFechaCreacion())) {
			errores.add(new ErrorDTO("LA FECHA DE CREACION NO PUEDE SER MAYOR A LA FECHA ACTUAL"));
		}
		if(isFechaFutura(obj.getFechaIngreso())) {
			errores.add(new ErrorDTO("LA FECHA DE INGRESO NO PUEDE SER MAYOR A LA FECHA ACTUAL"));
		}
		return errores;
	}
	private boolean isFechaFutura(Timestamp fecha) {
		return fecha.toLocalDateTime().isAfter(LocalDateTime.now());
	}
}
