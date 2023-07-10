package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IRegistroServiceRepository;
import ar.edu.unju.fi.service.IRegistroService;
@Service
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
	public Usuario findUsuarioById(Long id) {
		return registroserviceRepository.findById(id).get();
	}

	@Override
	public Usuario getUsuario() {
		return usuario;
	}

	@Override
	public void modificar(Usuario usuario) {
		registroserviceRepository.save(usuario);
		
	}

}
