package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IRegistroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/registros")
public class RegistroController {

	//region Dependencies
	@Autowired
	private IRegistroService registroService;

	@Autowired
	private Usuario unUsuario;
	//endregion

	//region Methods
	@GetMapping("/listado")
	public ModelAndView getRegistrosPage() {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("registros");
		modelAndView.addObject(
				"listaUsuarios",
				registroService.getAllUsuarios()
		);

		return modelAndView;

	}

	@GetMapping("/nuevo")
	public ModelAndView getNuevoRegistro() {

		ModelAndView modelAndView = new ModelAndView();
		boolean edicion = false;

		unUsuario = new Usuario();
		modelAndView.setViewName("nuevoRegistro");
		modelAndView.addObject(
				"registro",
				unUsuario
		);
		modelAndView.addObject("editar", edicion);

		return modelAndView;
	}
	
	@PostMapping("/guardar")
	public ModelAndView saveNewRegistro(
			@Valid @ModelAttribute("registro") Usuario usuario,
			BindingResult resultadoValidacion
	) {

	    ModelAndView modelAndView = new ModelAndView();

	    if (resultadoValidacion.hasErrors()) {
	        modelAndView.setViewName("nuevoRegistro");
	    } else {

			registroService.addUsuario(usuario);

			modelAndView.setViewName("redirect:/registros/listado");
			modelAndView.addObject(
					"listaRegistros",
					registroService.getAllUsuarios()
			);
		}

		return modelAndView;
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView getModificarRegistroPage(
			@PathVariable(value = "id") int id
	) {

		ModelAndView modelAndView = new ModelAndView();
		boolean edicion = true;

		unUsuario = registroService.findUsuarioById(id);
		modelAndView.setViewName("nuevoRegistro");
		modelAndView.addObject("usuario", unUsuario);
		modelAndView.addObject("editar", edicion);

		return modelAndView;
	}
	
	@GetMapping("/eliminar/{id}")
	public ModelAndView deleteRegistro(
			@PathVariable(value = "id") int id
	) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("redirect:/registro/listado");
		registroService.deleteUsuarioById(
				registroService.findUsuarioById(id)
		);

		return modelAndView;
	}
	//endregion

}
