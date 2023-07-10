package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactoController {
	/**
	 * Metodo que captura una peticion http en la forma de una url
	 * devuelve la pagina a mostrar.
	 * @return
	 */
	@GetMapping("/contacto")
	public String getContacto() {
		return "contacto";
	}
}
