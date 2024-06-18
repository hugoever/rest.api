package py.edu.ucsa.jweb.rest.api.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import py.edu.ucsa.jweb.rest.api.dto.UsuarioDTO;

@Service("usuarioService")
public class UsuarioServiceImpl {
	private static final AtomicLong counter=new AtomicLong();
	private static List<UsuarioDTO> usuarios;
	static {
		crearUsuariosEnMemoria();
	}
	
	public List<UsuarioDTO> listarTodos(){
		return usuarios;
	}
	
	public UsuarioDTO getById(long id) {
		for(UsuarioDTO user : usuarios) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public UsuarioDTO getByUsuario(String usuario) {
		for(UsuarioDTO u : usuarios) {
			if(u.getUsuario().equalsIgnoreCase(usuario)){
				return u;
			}
		}
		return null;
	}
	
	public void crearUsuario(UsuarioDTO usuario) {
		usuario.setId(counter.incrementAndGet());
		usuarios.add(usuario);
		
	}
	
	public void actualizarUsuario(UsuarioDTO usuario) {
		int index = usuarios.indexOf(usuario);
		usuarios.set(index, usuario);		
	}
	
	public void eliminarUsuarioById(long id) {
		for(Iterator<UsuarioDTO> iterator = usuarios.iterator(); iterator.hasNext();) {
			UsuarioDTO u = iterator.next();		
			if(u.getId()==id) {
				iterator.remove();
			}
		}
	}
	
	public boolean isExisteUsuario(UsuarioDTO usuario) {
		return getByUsuario(usuario.getUsuario())!=null;
	}
	
	public void eliminarTodos(){
		usuarios.clear();
	}
	
	public static List<UsuarioDTO> crearUsuariosEnMemoria(){
		List<UsuarioDTO> usuarios = new ArrayList<>();
		usuarios.add(new UsuarioDTO(counter.incrementAndGet(),"jsanchez","jsanchez@gmail.com","123","JUAN","SANCHEZ",true,false,false,LocalDateTime.now()));
		usuarios.add(new UsuarioDTO(counter.incrementAndGet(),"aslachevsky","aslachevsky@gmail.com","123","ANDY","SLACHEVSKY",true,false,false,LocalDateTime.now()));
		return usuarios;
//		private Long id;
//		private String usuario;
//		private String email;
//		private String clave;
//		private String nombres;
//		private String apellidos;
		
//		private Boolean habilitado;
//		private Boolean cuenta_bloqueada;
//		private Boolean cuenta_expirada;
//		private LocalDateTime fechaCreacion;
	}

	
}
