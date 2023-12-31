
package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.entity.Usuario;

public interface IRegistroService {

	void addUsuario(Usuario usuario);

	List<Usuario> getAllUsuarios();

	void deleteUsuarioById(Usuario usuario);

	Usuario findUsuarioById(Long id);

	Usuario getUsuario();
	
	void modificar(Usuario usuario);
	
	Optional<Usuario> buscarUsuarioById(Long id);
}
