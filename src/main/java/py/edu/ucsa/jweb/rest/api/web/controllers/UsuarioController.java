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

import py.edu.ucsa.jweb.rest.api.core.entities.Usuario;
import py.edu.ucsa.jweb.rest.api.core.services.UsuarioService;
import py.edu.ucsa.jweb.rest.api.web.dto.ErrorDTO;


@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Integer id){
		Usuario dto = usuarioService.getById(id);
		return ResponseEntity.ok(dto);
	}	
	
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(usuarioService.listar());
	}
	
	
	
	@GetMapping("/{usuario}/usuario")
	public ResponseEntity<?> getByUsuario(@PathVariable("usuario") String usuario){
		Usuario dto = usuarioService.getByUsuario(usuario);
		return ResponseEntity.ok(dto);
	}
	
//	@GetMapping
//	public ResponseEntity<?> listarTodos(){
//		List<Usuario> dto = usuarioService.listar();
//
//		return ResponseEntity.ok(dto);
//	}
//	
	@PostMapping
	public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario, UriComponentsBuilder ucBuilder){
		logger.info("Creando el Usuario : {}", usuario);
		if(usuarioService.isExisteUsuario(usuario.getUsuario())) {
			logger.error("Inserción fallida. Ya existe un registro con el usuario {}", usuario.getUsuario());
			
			return new ResponseEntity<ErrorDTO>(new ErrorDTO(
					"Inserción Fallida. Ya existe un registro con el usuario"+
						usuario.getUsuario()), HttpStatus.CONFLICT);
		}
		Usuario insertado = usuarioService.persistir(usuario);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/usuarios/{id}").buildAndExpand(insertado.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<?> actualizarUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuario){
		logger.info("Actualizando el Usuario con id {}", id);
		Usuario usuarioBD = usuarioService.getById(id);
		if(Objects.isNull(usuarioBD)) {
			logger.error("Actualización fallida. No existe el usuario con el id {}",id);
			return new ResponseEntity<ErrorDTO>(
				new ErrorDTO("Actualización fallida. No existe el usuario con el id "+ 
						id), HttpStatus.NOT_FOUND);
				
			}
//			usuarioBD.setApellidos(usuario.getApellidos());
//			usuarioBD.setClave(usuario.getClave());
//			usuarioBD.setCuentaBloqueada(usuario.getCuentaBloqueada());
//			usuarioBD.setCuentaExpirada(usuario.getCuentaExpirada());
//			usuarioBD.setEmail(usuario.getEmail());
//			usuarioBD.setFechaCreacion(usuario.getFechaCreacion());
//			usuarioBD.setHabilitado(usuario.getHabilitado());
			usuarioService.actualizar(usuario);
			
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable("id") Integer id){
		logger.info("Eliminación de Usuario con el id {}", id);
		Usuario usuarioBD = usuarioService.getById(id);
				
		if(usuarioBD == null) {
			logger.error("Eliminación fallida. No existe el usuario con el id {}",id);
			return new ResponseEntity<ErrorDTO>(
					new ErrorDTO("Eliminación fallida. No existe el usaurio con el id "+
							id), HttpStatus.NOT_FOUND);
					
		}
		
		String usuarioEliminado = usuarioBD.getUsuario();
		usuarioService.eliminar(usuarioBD);
		
		return new ResponseEntity<ErrorDTO>(
				new ErrorDTO("El usuario: "+
						usuarioEliminado +" fué eliminado exitosamente."),HttpStatus.OK);
	
	}
	
//	@DeleteMapping("/eliminarTodos")
//	public ResponseEntity<?> eliminarTodos(){
//		logger.info("Eliminación de todos los Usuarios");
//		usuarioService..eliminarTodos();
//		return new ResponseEntity<ErrorDTO>(
//				new ErrorDTO("Se eliminaron todos los usuarios"),HttpStatus.OK);
//	}

}
