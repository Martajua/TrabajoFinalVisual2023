package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IRegistroService;
import jakarta.validation.Valid;

@Controller

@RequestMapping("/registro")
public class RegistroController {

	/*
	 * la anotación @RequestMapping("/registro") indica que todas las solicitudes
	 * que comiencen con "/registro" serán manejadas por los métodos de este
	 * controlador. Por ejemplo, si hay un método en el controlador con la
	 * anotación @GetMapping("/listado"), se mapeará a la URL "/registro/listado".
	 */

	@Autowired
	private IRegistroService registroService;

	/**
	 * Metodo que captura una peticion http en la forma de una url devuelve la
	 * pagina a mostrar.
	 * 
	 * @return
	 */
	@GetMapping("/listado")
	public String getListaRegistros(Model model) {
		model.addAttribute("registros",registroService.getAllUsuarios());
		return "registros";
	}

	/*
	 * Carga la vista del formulario. Cuando la variable edición sea falsa se va a
	 * cargar el formulario para realizar un alta
	 */

	@GetMapping("/nuevo")
	public String getNuevoRegistro(Model model) {
		boolean edicion = false;
		model.addAttribute("registro", registroService.getUsuario());
		model.addAttribute("edicion", edicion);
		return "form_registros";
	}

	/*
	 * Recibe los datos enviados por el formulario y realiza el alta de un registro
	 */

	@PostMapping("/guardar")
	public ModelAndView getGuardarRegistro(@Valid @ModelAttribute("registro") Usuario usuario, BindingResult result) {
	    ModelAndView modelView = new ModelAndView("form_registros");
	    if (result.hasErrors()) {
	        modelView.addObject("registro", usuario);
	        return modelView;
	    }
	    usuario.setEstado(true);
	    usuario.setAdmin(false);
	    registroService.addUsuario(usuario);

	    // Obtener el ID del usuario guardado
	    Long userId = usuario.getId();

	    // Pasar el ID del usuario al modelo
	    modelView.addObject("userId", userId);

	    return modelView;
	}

	/*
	 * Carga la vista del formulario. Cuando la variable edición sea "verdadera" se
	 * carga en el formulario los datos para modificarlos de acuerdo al ID
	 * establecido
	 */

	@GetMapping("/modificar/{id}")
	public String getModificarRegistro(Model model, @PathVariable(value = "id") Long id) {
		boolean edicion = true;
		Usuario usuarioEncontrado= registroService.findUsuarioById(id);
		// metodos de la capa service
		model.addAttribute("registro",usuarioEncontrado);
		model.addAttribute("edicion", edicion);
		return "form_registros";
	}

	/* Aqui se reciben los datos enviados por el formularios a modificar y se modifican los datos
	 * del usuario existente. */

	@PostMapping("/modificar")
	public String modificarRegistro(@Valid @ModelAttribute("registro") Usuario usuario, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			// métodos de la capa service
			boolean edicion = true;
			model.addAttribute("edicion", edicion);
			return "form_registros";
		}
		registroService.modificar(usuario);
		return "redirect:/registro/listado";
	}

	/* Se elimina un registro de acuerdo al id seleccionado */

	@GetMapping("/eliminar/{id}")
	public String getEliminarRegistro(Model model, @PathVariable(value = "id") Long id) {
		Usuario usuarioEncontrado = registroService.findUsuarioById(id);
		registroService.deleteUsuarioById(usuarioEncontrado);
		return "redirect:/registro/listado";
	}
}
