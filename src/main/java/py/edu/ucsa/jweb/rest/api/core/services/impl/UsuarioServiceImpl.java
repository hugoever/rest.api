package py.edu.ucsa.jweb.rest.api.core.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import py.edu.ucsa.jweb.rest.api.core.services.UsuarioService;
import py.edu.ucsa.jweb.rest.api.web.dto.UsuarioDTO;

@Service("UsuarioService")
public class UsuarioServiceImpl implements UsuarioService {
	private static final AtomicLong counter = new AtomicLong();
	private static List<UsuarioDTO> usuarios;
	static {
		usuarios = crearUsuariosEnMemoria();
	}

	@Override
	public List<UsuarioDTO> listarTodos() {
		return usuarios;
	}
	
	@Override
	public UsuarioDTO getById(long id) {
		for (UsuarioDTO user : usuarios) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public UsuarioDTO getByUsuario(String usuario) {
		if (Objects.nonNull(usuario)) {
			for (UsuarioDTO u : usuarios) {
				if (u.getUsuario().equalsIgnoreCase(usuario)) {
					return u;
				}
			}
		}

		return null;
	}



	public static List<UsuarioDTO> crearUsuariosEnMemoria() {
		List<UsuarioDTO> usuarios = new ArrayList<>();
//METODO 1: con el @AllArgsConstructor en el DTO, se deben pasar todos los argumentos para la inserción

		usuarios.add(new UsuarioDTO(counter.incrementAndGet(), "jsanchez", "jsanchez@gmail.com", "123", "JUAN",
				"SANCHEZ", true, false, false, LocalDateTime.now()));
		usuarios.add(new UsuarioDTO(counter.incrementAndGet(), "aslachevsky", "aslachevsky@gmail.com", "123", "ANDY",
				"SLACHEVSKY", true, false, false, LocalDateTime.now()));

//METODO 2: CON BUILDER

		usuarios.add(UsuarioDTO.builder().id(counter.incrementAndGet()).usuario("pgonzalez")
				.email("pgonzalez@gmail.com").clave("123").nombres("PEDRO").apellidos("GONZALEZ").habilitado(true)
				.cuentaBloqueada(false).cuentaExpirada(false).fechaCreacion(LocalDateTime.now()).build());

//METODO 3: 
//	Los getters y setters se generaron con la anotación @Data en el DTO
//	y el constructor con el @NoArgsConstructor
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(counter.incrementAndGet());
		dto.setUsuario("jfernandez");
		dto.setEmail("jfernandez@gmail.com");
		dto.setClave("123");
		dto.setNombres("JOSE");
		dto.setApellidos("FERNANDEZ");
		dto.setHabilitado(true);
		dto.setCuentaBloqueada(false);
		dto.setCuentaExpirada(false);
		dto.setFechaCreacion(LocalDateTime.now());
		usuarios.add(dto);

		return usuarios;

	}

	@Override
	public void crearUsuario(UsuarioDTO usuario) {
		usuario.setId(counter.incrementAndGet());
		usuario.setFechaCreacion(LocalDateTime.now());
		usuarios.add(usuario);

	}

	@Override
	public void actualizarUsuario(UsuarioDTO usuario) {
		int index = usuarios.indexOf(usuario);
		usuarios.set(index, usuario);
	}

	@Override
	public void eliminarUsuario(long id) {
		for (Iterator<UsuarioDTO> iterator = usuarios.iterator(); iterator.hasNext();) {
			UsuarioDTO u = iterator.next();
			if (u.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	@Override
	public void eliminarTodos() {
		usuarios.clear();
	}

	@Override
	public boolean isExisteUsuario(UsuarioDTO usuario) {
		return Objects.nonNull(getByUsuario(usuario.getUsuario()));
	}



}
