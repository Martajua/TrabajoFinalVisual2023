package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Usuario;

public interface IRegistroService {

	public void addUsuario(Usuario usuario);

	public List<Usuario> getAllUsuarios();

	public void deleteUsuarioById(Usuario usuario);

	public Usuario findUsuarioById(Integer id);
}
