package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IRegistroRepository;
import ar.edu.unju.fi.service.IRegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("registroServiceImp")
public class RegistroServiceImp implements IRegistroService {

	//region Dependencies
	@Autowired
	private IRegistroRepository registroRepository;

	@Autowired
	private Usuario usuario;
	//endregion

	//region Methods
	@Override
	public void addUsuario(Usuario usuario) {
		registroRepository.save(usuario);
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		return registroRepository.findByEstado(true);
	}

	@Override
	public Usuario findUsuarioById(int id) {
		usuario = registroRepository.findById(id).get();
		return usuario;
	}

	@Override
	public void deleteUsuarioById(Usuario usuario) {
		usuario.setEstado(false);
		registroRepository.save(usuario);
	}
	//endregion

}
