package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Usuario;

import java.util.List;

public interface IRegistroService {

	//region Methods
	public void addUsuario(Usuario usuario);

	public List<Usuario> getAllUsuarios();

	public Usuario findUsuarioById(int id);

	public void deleteUsuarioById(Usuario usuario);
	//endregion

}
