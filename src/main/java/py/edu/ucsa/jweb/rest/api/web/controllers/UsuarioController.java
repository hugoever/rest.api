package py.edu.ucsa.jweb.rest.api.web.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import py.edu.ucsa.jweb.rest.api.core.services.UsuarioService;
import py.edu.ucsa.jweb.rest.api.web.dto.ErrorDTO;
import py.edu.ucsa.jweb.rest.api.web.dto.UsuarioDTO;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id){
		UsuarioDTO dto = usuarioService.getById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<UsuarioDTO> dto = usuarioService.listarTodos();
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO usuario, UriComponentsBuilder ucBuilder){
		logger.info("Creando el Usuario : {}", usuario);
		if(usuarioService.isExisteUsuario(usuario)) {
			logger.error("Inserción fallida. Ya existe un registro con el usuario {}", usuario.getUsuario());
			
			return new ResponseEntity<ErrorDTO>(new ErrorDTO(
					"Inserción Fallida. Ya existe un registro con el usuario"+
						usuario.getUsuario()), HttpStatus.CONFLICT);
		}
		usuarioService.crearUsuario(usuario);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> actualizarUsuario(@PathVariable("id") long id, @RequestBody UsuarioDTO usuario){
		logger.info("Actualizando el Usuario con id {}", id);
		UsuarioDTO usuarioBD = usuarioService.getById(id);
		if(usuarioBD == null) {
			logger.error("Actualización fallida. No existe el usuario con el id {}",id);
			return new ResponseEntity<ErrorDTO>(
				new ErrorDTO("Actualización fallida. No existe el usuario con el id "+ 
						id), HttpStatus.NOT_FOUND);
				
			}
			usuarioBD.setApellidos(usuario.getApellidos());
			usuarioBD.setClave(usuario.getClave());
			usuarioBD.setCuentaBloqueada(usuario.getCuentaBloqueada());
			usuarioBD.setCuentaExpirada(usuario.getCuentaExpirada());
			usuarioBD.setEmail(usuario.getEmail());
			usuarioBD.setFechaCreacion(usuario.getFechaCreacion());
			usuarioBD.setHabilitado(usuario.getHabilitado());
			usuarioService.actualizarUsuario(usuarioBD);
			
			return new ResponseEntity<UsuarioDTO>(usuarioBD, HttpStatus.OK);
		}
	
	

}
