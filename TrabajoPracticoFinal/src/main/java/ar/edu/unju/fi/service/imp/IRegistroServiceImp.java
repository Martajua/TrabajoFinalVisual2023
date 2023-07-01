package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IRegistroServiceRepository;
import ar.edu.unju.fi.service.IRegistroService;

public class IRegistroServiceImp implements IRegistroService {

	@Autowired
	private Usuario usuario;

	@Autowired
	private IRegistroServiceRepository registroserviceRepository;

	@Override
	public void addUsuario(Usuario usuario) {

		registroserviceRepository.save(usuario);

	}

	@Override
	public List<Usuario> getAllUsuarios() {
		List<Usuario> usuario = registroserviceRepository.findByEstado(true);
		return usuario;
	}

	@Override
	public void deleteUsuarioById(Usuario usuario) {
		usuario.setEstado(false);
		registroserviceRepository.save(usuario);
	}

	@Override
	public Usuario findUsuarioById(Integer id) {
		usuario = registroserviceRepository.findById(id).get();
		return usuario;
	}

}
