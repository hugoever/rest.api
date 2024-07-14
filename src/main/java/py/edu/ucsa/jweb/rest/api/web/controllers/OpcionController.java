package py.edu.ucsa.jweb.rest.api.web.controllers;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import py.edu.ucsa.jweb.rest.api.core.entities.Opcion;
import py.edu.ucsa.jweb.rest.api.core.services.OpcionService;
import py.edu.ucsa.jweb.rest.api.web.dto.ErrorDTO;

@RestController
@RequestMapping("opciones")
public class OpcionController {
	
	private static final Logger logger = LoggerFactory.getLogger(OpcionController.class);
	
	@Autowired
	@Qualifier("opcionService")
	private OpcionService opcionService;
	
	@GetMapping
	public ResponseEntity<?> listar(){		
		return ResponseEntity.ok(opcionService.listar());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Integer id){
		Opcion dto = opcionService.getById(id);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<?> crearOpcion(@RequestBody Opcion opcion, UriComponentsBuilder ucBuilder){
		logger.info("Creando Opción: {}", opcion);
		opcionService.persistir(opcion);
		HttpHeaders header = new HttpHeaders();
		header.setLocation(ucBuilder.path("/opciones/{id}").buildAndExpand(opcion.getId()).toUri());
		return new ResponseEntity<String>(header, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> actualizarOpcion(@PathVariable("id") Integer id, @RequestBody Opcion opcion){
		logger.info("Actualizando opción con el id: {}", id);
		Opcion opcionBD = opcionService.getById(id);
		if(Objects.isNull(opcionBD)){
			logger.error("Actualización fallida, no existe la opción: {}", id);
			return new ResponseEntity<ErrorDTO>(
					new ErrorDTO("Actualización fallida. No existe la opción con el id "+ 
							id), HttpStatus.NOT_FOUND
					);
		}
		opcionService.actualizar(opcionBD);
		return new ResponseEntity<Opcion>(opcion, HttpStatus.OK);
		
		}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> eliminarOpcion(@PathVariable("id") Integer id){
		logger.info("Eliminando la opción con el id: {}", id);
		Opcion opcionBD = opcionService.getById(id);
		if(Objects.isNull(opcionBD)) {
			logger.error("Eliminación fallida, no existe la opción: {}", id);
			return new ResponseEntity<ErrorDTO>(
					new ErrorDTO("Eliminación fallida, no existe la opción con el id: "+
							id), HttpStatus.NOT_FOUND
					);
		}
		String opcionEliminada = opcionBD.getDescripcion();
		opcionService.eliminar(opcionBD);
		return new ResponseEntity<ErrorDTO>(
				new ErrorDTO("La opción: " + opcionEliminada +
						" fue eliminada exitosamente."), HttpStatus.OK
						);
				
	}
	
	@GetMapping("pordominio/{dominio}")
	public ResponseEntity<?> getOpcionesByCodDominio(@PathVariable("dominio") String dominio){
		return ResponseEntity.ok(opcionService.getOpcionesByCodDominio(dominio));
	}
	
	@GetMapping("/porcodigoydominio/{codigo}/{dominio}")
	public ResponseEntity<?> getOpcionesByCodigoYCodDominio(@PathVariable("codigo") String codigo, @PathVariable("dominio") String dominio){
		return ResponseEntity.ok(opcionService.getOpcionesByCodigoYCodDominio(codigo, dominio));
	}
	

}
