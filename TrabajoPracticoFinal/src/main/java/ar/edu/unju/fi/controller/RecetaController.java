package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.service.IRecetaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/receta")
public class RecetaController {
	
	/*
	 * la anotación @RequestMapping("/receta") indica que todas las solicitudes
	 * que comiencen con "/registro" serán manejadas por los métodos de este
	 * controlador. Por ejemplo, si hay un método en el controlador con la
	 * anotación @GetMapping("/listado"), se mapeará a la URL "/receta/listado".
	 */
	
	@Autowired
	private IRecetaService recetaService;
	
	/**
	 * Metodo que captura una peticion http en la forma de una url devuelve la
	 * pagina a mostrar.
	 * 
	 * @return
	 */
	@GetMapping("/listado")
	public String getListaRecetas(Model model) {
		// metodos de la capa service
		return "recetas";
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
		return "FORMULARIO DE INGREDIENTES DE RECETA";
	}
	
	/*
	 * Recibe los datos enviados por el formulario y realiza el alta de un registro
	 * 
	 */
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarReceta(@Valid @ModelAttribute("receta") Receta receta, BindingResult result) {
	    ModelAndView modelView = new ModelAndView("recetas");
	    if (result.hasErrors()) {
	        modelView.setViewName("registros");
	      //metodos de la capa service
	        modelView.addObject("receta", receta);
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
	public String getModificarReceta(Model model, @PathVariable(value = "id") Long id) {
		boolean edicion = true;
		//metodos de la capa service
		model.addAttribute("edicion", edicion);
		return "FORMULARIO DE INGREDIENTES DE RECETA";
	}
	
	/*
	 * Aqui se reciben los datos enviados por el formularios a modificar.
	 * 
	 */
	
	@PostMapping("/modificar")
	public String modificarReceta(@Valid @ModelAttribute("receta") Receta receta, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			//metodos de la capa service
			boolean edicion = true;
			model.addAttribute("edicion", edicion);
			return "FORMULARIO DE INGREDIENTES DE RECETA";
			
		}
		//metodos de la capa service
		return "redirect:/receta/listado";
	}
	
	/*
	 * Se elimina una receta de acuerdo al id seleccionado
	 */
	
	@GetMapping("/eliminar/{id}")
	public String getEliminarReceta(Model model, @PathVariable(value = "id") Long id) {
		//metodos de la capa service
		return "redirect:/registro/listado";
	}
}
