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
	public String getListaRegistrosPage(Model model) {
		//metodos de la capa service
		return "VISTA DE REGISTROS";
	}
	
	/*
	 * Carga la vista del formulario. Cuando la variable edición sea falsa se va a
	 * cargar el formulario para realizar un alta
	 * 
	 */
	
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion = false;
		//metodos de la capa service
		model.addAttribute("edicion", edicion);
		return "registros";
	}
	
	/*
	 * Recibe los datos enviados por el formulario y realiza el alta de un registro
	 * 
	 */
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarRegistroPage(@Valid @ModelAttribute("registro") Usuario usuario, BindingResult result) {
	    ModelAndView modelView = new ModelAndView("VISTA DE REGISTROS");
	    if (result.hasErrors()) {
	        modelView.setViewName("registros");
	        modelView.addObject("registro", usuario);
	        return modelView;
	    }
	    // métodos de la capa service
	    return modelView;
	}
	
	/*
	 * Carga la vista del formulario. Cuando la variable edición sea "verdadera" se
	 * carga en el formulario los datos para modificarlos de acuerdo al ID
	 * establecido
	 */
	
	@GetMapping("/modificar/{id}")
	public String getModificarRegistroPage(Model model, @PathVariable(value = "id") Long id) {
		boolean edicion = true;
		//metodos de la capa service
		model.addAttribute("edicion", edicion);
		return "registros";
	}
	
	/*
	 * Aqui se reciben los datos enviados por el formularios a modificar.
	 * 
	 */
	
	@PostMapping("/modificar")
	public String modificarSucursal(@ModelAttribute("registro") Usuario usuario, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			//metodos de la capa service
			boolean edicion = true;
			model.addAttribute("edicion", edicion);
			return "registros";
			
		}
		//metodos de la capa service
		return "redirect:/registro/listado";
	}
	
	/*
	 * Se elimina un registro de acuerdo al id seleccionado
	 */
	
	@GetMapping("/eliminar/{id}")
	public String getEliminatSucursalPage(Model model, @PathVariable(value = "id") Long id) {
		//metodos de la capa service
		return "redirect:/registro/listado";
	}
}
