package ar.edu.unju.fi;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IRegistroService;

@SpringBootTest
class TrabajoPracticoFinalApplicationTests {
	@Autowired
	private IRegistroService registroService;
	Usuario usuario;
	
	@Test
	void guardaUsuario() {
		usuario=new Usuario();
		usuario.setApellido("Saravia");
		usuario.setEmail("asd123@gmail.com");
		usuario.setEstado(true);
		usuario.setEstatura((float) 1.90);
		usuario.setFechaNacimiento(LocalDate.of(2012, 05, 20));
		usuario.setNombre("Estefania");
		usuario.setSexo("femenino");
		usuario.setTelefono("14020480");
		registroService.addUsuario(usuario);
	}

}
