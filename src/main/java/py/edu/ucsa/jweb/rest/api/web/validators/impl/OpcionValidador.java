package py.edu.ucsa.jweb.rest.api.web.validators.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import py.edu.ucsa.jweb.rest.api.core.entities.Opcion;
import py.edu.ucsa.jweb.rest.api.web.dto.ErrorDTO;
import py.edu.ucsa.jweb.rest.api.web.validators.Validador;

public class OpcionValidador implements Validador<Opcion> {

	@Override
	public List<ErrorDTO> validar(Opcion obj) {
		List<ErrorDTO> errores = new ArrayList<>();
		
		//VALIDACIONES A VERIFICAR
		if(Objects.isNull(obj.getCodigo())) {
			errores.add(new ErrorDTO("EL CODIGO DE OPCION ES REQUERIDO"));
		}
		if(Objects.isNull(obj.getDescripcion())) {
			errores.add(new ErrorDTO("LA DESCRIPCION ES REQUERIDA"));
		}
		
		//SINO NO HAY VALIDACIONES A REALIZAR 
		//CONVERTIR A MAYUSCULAS
		if(errores.isEmpty()) {
			obj.setCodigo(obj.getCodigo().toUpperCase());
			obj.setDescripcion(obj.getDescripcion().toUpperCase());
		}
		return errores;
	}

}
