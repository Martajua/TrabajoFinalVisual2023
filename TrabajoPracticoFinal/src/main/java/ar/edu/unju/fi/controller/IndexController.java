package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	/**
	 * Metodo que captura una peticion http en la forma de una url
	 * devuelve la pagina a mostrar.
	 * @return
	 */
	@GetMapping("index")
	public String getIndex() {
		return "inicio";
	}
}
